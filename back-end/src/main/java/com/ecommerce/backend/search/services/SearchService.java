package com.ecommerce.backend.search.services;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.search.model.ResultQuery;
import com.ecommerce.backend.utils.Constants;
import com.ecommerce.backend.utils.HelperFunctions;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {

	@Value("${api.elasticsearch.uri}")
	private String elasticSearchUri;

	@Value("${api.elasticsearch.search}")
	private String elasticSearchSearchPrefix;

	public ResultQuery searchFromQuery(String query) throws IOException {
		String body = HelperFunctions.buildMultiIndexMatchBody(query);
		return executeHttpRequest(body);
	}

	private ResultQuery executeHttpRequest(String body) throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			ResultQuery resultQuery = new ResultQuery();
			HttpPost httpPost = new HttpPost(
					HelperFunctions.buildSearchUri(elasticSearchUri, "", elasticSearchSearchPrefix));
			httpPost.setHeader(Constants.CONTENT_ACCEPT, Constants.APP_TYPE);
			httpPost.setHeader(Constants.CONTENT_TYPE, Constants.APP_TYPE);
			try {
				httpPost.setEntity(new StringEntity(body, Constants.ENCODING_UTF8));
				HttpResponse response = httpClient.execute(httpPost);
				String message = EntityUtils.toString(response.getEntity());
				JSONObject myObject = new JSONObject(message);
				if (myObject.getJSONObject(Constants.HITS)
						.getInt(Constants.TOTAL_HITS) != 0) {
					resultQuery
							.setElements(myObject
									.getJSONObject(Constants.HITS)
									.getJSONArray(Constants.HITS)
									.toString());
					resultQuery
							.setNumberOfResults(myObject.getJSONObject(Constants.HITS)
									.getInt(Constants.TOTAL_HITS));
					resultQuery.setTimeTook((float) ((double) myObject.getInt(Constants.TOOK) / Constants.TO_MS));
				} else {
					resultQuery.setElements(null);
					resultQuery.setNumberOfResults(0);
					resultQuery.setTimeTook((float) ((double) myObject.getInt(Constants.TOOK) / Constants.TO_MS));
				}
			} catch (IOException | JSONException e) {
				log.error("Error while connecting to elastic engine --> {}", e.getMessage());
				resultQuery.setNumberOfResults(0);
			}

			return resultQuery;
		}
	}
}
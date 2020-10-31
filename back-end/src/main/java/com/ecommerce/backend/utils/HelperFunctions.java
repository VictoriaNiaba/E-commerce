package com.ecommerce.backend.utils;

import org.json.JSONArray;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class HelperFunctions {

	private final String[] USER_FIELDS = { "firstName", "lastName" };

	/**
	 * Construct the query body for multi index matching
	 *
	 * @param query String
	 * @return String
	 */
	public String buildMultiIndexMatchBody(String query) {
		return "{\n" +
				"\"from\": 0,\n" +
				"\"size\": 100,\n" +
				"\"track_total_hits\": true,\n" +
				"\"sort\" : {\n" +
				"      \"id\": {\"order\": \"asc\"}\n" +
				"      },\n" +
				"  \"query\": {\n" +
				"    \"query_string\" : {\n" +
				"      \"query\":      \"*" + query + "*\",\n" +
				"      \"fields\":     " + new JSONArray(Arrays.asList(USER_FIELDS)) + ",\n" +
				"      \"default_operator\": \"AND\"\n" +
				"    }\n" +
				"  },\n" +
				"  \"highlight\": {\n" +
				"    \"fields\": {\n" +
				"      \"*\": {}\n" +
				"    },\n" +
				"    \"require_field_match\": true\n" +
				" }\n" +
				"}";
	}

	public String buildSearchUri(String elasticSearchUri,
			String elasticSearchIndex,
			String elasticSearchSearch) {
		return elasticSearchUri + elasticSearchIndex + elasticSearchSearch;
	}
}

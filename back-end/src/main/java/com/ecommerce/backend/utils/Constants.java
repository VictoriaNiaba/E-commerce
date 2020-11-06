package com.ecommerce.backend.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

	public final Integer INTERVAL_IN_MILLISECONDS = 180_000;
	public final String MODIFICATION_DATE = "modificationDate";

	public final String SEARCH_QUERY = "/query";
	public final String QUERY = "query";
	public final String HITS = "hits";
	public final String TOOK = "took";
	public final String TOTAL_HITS = "total";
	public final String CONTENT_ACCEPT = "Accept";
	public final String APP_TYPE = "application/json";
	public final String CONTENT_TYPE = "Content-type";
	public final Integer TO_MS = 1000;
	public final String ENCODING_UTF8 = "UTF-8";
}

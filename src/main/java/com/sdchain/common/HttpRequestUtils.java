package com.sdchain.common;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

@SuppressWarnings("deprecation")
public class HttpRequestUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	/**
	 * httpPost
	 * 
	 * @param url
	 * @param jsonParam
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam) {
		return httpPost(url, jsonParam, false);
	}

	/**
	 * post
	 * 
	 * @param url
	 * @param jsonParam
	 * @param noNeedResponse
	 * @return
	 */
	@SuppressWarnings("resource")
	public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			String str = "";
			try {
				str = EntityUtils.toString(result.getEntity());
				if (noNeedResponse) {
					return null;
				}
				jsonResult = JSONObject.fromObject(str);
			} catch (Exception e) {
				logger.error("post fail:" + url, e);
			}
		} catch (IOException e) {
			logger.error("post fail:" + url, e);
		}
		return jsonResult;
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	@SuppressWarnings("resource")
	public static JSONObject httpGet(String url) {
		JSONObject jsonResult = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// send get request
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			String strResult = EntityUtils.toString(response.getEntity());
			jsonResult = JSONObject.fromObject(strResult);
			url = URLDecoder.decode(url, "UTF-8");
		} catch (IOException e) {
			logger.error("get fail:" + url, e);
		}
		return jsonResult;
	}

}

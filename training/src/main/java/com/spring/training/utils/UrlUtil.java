package com.spring.training.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class UrlUtil {
	
	public static String encode(String val, String enc) {
		try {
			return URLEncoder.encode(val, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encode(String val) {
		return encode(val, "UTF-8");
	}
	
	public static String makeParam(Map<String, String> paramMap, String[] excepKeys) {
		
		try {
			StringBuilder sb = new StringBuilder();
			
			Iterator<String> iter = paramMap.keySet().iterator();
			
			int idx = 0;
			while (iter.hasNext()) {
				
				if (idx == 0) {
					sb.append("?");
				} else {
					sb.append("&");
				}
				
				String key = encode(iter.next());
				String val = encode(paramMap.get(key));
				if (excepKeys != null) {
					for (String ekey : excepKeys) {
						if (key.equals(ekey.trim())) {
							val = paramMap.get(key);
							break;
						}
					}
				}
				
				
				sb.append(key).append("=").append(val);
				
				idx++;
			}
			
			
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String makeParam(Map<String, String> paramMap) {
		return makeParam(paramMap, null);
	}
	
	public static String connectHttp(String urlString, String method, Map<String, String> reqProps) {
		
		try {
			
			URL url = new URL(urlString);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-type", "application/json");
			
			if (reqProps != null) {
				Iterator<String> iter = reqProps.keySet().iterator();
				
				while (iter.hasNext()) {
					String key = iter.next();
					String val = reqProps.get(key);
					
					conn.setRequestProperty(key, val);
				}
			}
			
			System.out.println("Response code: " + conn.getResponseCode());
			
			BufferedReader rd;
			
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			
			rd.close();
			conn.disconnect();
			
			System.out.println("Response Message: " + sb.toString());
			
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String connectHttp(String url, String method) {
		return connectHttp(url, method, null);
	}
	
}

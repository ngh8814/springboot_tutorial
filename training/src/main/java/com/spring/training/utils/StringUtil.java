package com.spring.training.utils;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StringUtil {

	public static float parseFloat(String str) {
		try {
			return Float.parseFloat(str);
		} catch (Exception e) {
			return 0f;
		}
	}
	
	public static int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static LocalDateTime parseLocalDateTime(String str, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		try {
			return LocalDateTime.parse(str, formatter);
		} catch (DateTimeParseException e) {
			return null;
		}
		
	}
	
	public static String toString(LocalDateTime dt, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		try {
			return dt.format(formatter);
		} catch (DateTimeException e) {
			return null;
		}
        
	}
	
	public static String toString(LocalDateTime dt) {
		return toString(dt, "yyyy-MM-dd HH:mm:ss");
	}
	
}

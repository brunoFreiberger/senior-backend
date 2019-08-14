package com.br.senior.utils;

import java.util.Collection;
import java.util.List;

public class CommonUtils {
	
	public static <T extends Collection<?>> boolean isNullOrEmpty(T obj) {
		return obj == null || obj.isEmpty();
	}
	
	public static boolean isNullOrEmpty(List<?> data) {
		return data == null || data.isEmpty();
	}
	
	public static boolean isNull(String obj) {
		return obj == null || obj.trim().isEmpty();
	}
	
	public static boolean isNull(Long value) {
		return value == null;
	}
	
}

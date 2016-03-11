package com.sitechecker.utils;

import java.util.Iterator;
import java.util.Set;

import com.sitechecker.domain.Inspect;

public class JsonUtil {

	public static String inspectSet2Json(Set<Inspect> set){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Iterator<Inspect> it = set.iterator(); it.hasNext();){
			Inspect inspect = it.next();
			sb.append("{");
			sb.append(sqm("name", inspect.getName()));
			sb.append(",");
			sb.append(sqm("isid", inspect.getIsid()));
			sb.append("},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}

	private static String sqm(String key, Object value ) {
		return "\"" + key + "\":\"" + value.toString() + "\"";
	}

}

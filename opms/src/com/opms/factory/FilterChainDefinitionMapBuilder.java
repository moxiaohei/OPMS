package com.opms.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		map.put("/logout", "logout");
		map.put("/tologin", "anon");
		//map.put("/login.jsp", "anon");
		map.put("/signin", "anon");
		map.put("/css/**", "anon");
		map.put("/js/**", "anon");
		map.put("/img/**", "anon");
		map.put("/tologout", "anon");
		
		
		map.put("/**", "authc");
		
		return map;
	}
	
}

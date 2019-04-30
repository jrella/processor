package com.jr.scrap.processor.collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HtmlCollector {
	@Autowired
	RestTemplate restTemplate;
	
	public String collect(String pUrl) {
		return restTemplate.getForObject("http://localhost:8081/html?url=" + pUrl, String.class);
	}
}

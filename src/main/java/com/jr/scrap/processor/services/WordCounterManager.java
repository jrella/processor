package com.jr.scrap.processor.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jr.scrap.processor.collectors.HtmlCollector;

@Service
public class WordCounterManager {
	@Autowired
	HtmlCollector htmlCollector;

	public Map<String,Integer> run(List<String> pWords, String pUrl) {
		
		Map<String, Integer> mapWords = new HashMap<>();		
		
		String htmlBody = htmlCollector.collect(pUrl);
		
		pWords.stream().distinct().forEach(word -> {
			int contador = 0;
			StringTokenizer tok = new StringTokenizer(htmlBody);
			while(tok.hasMoreTokens()) {
				if(tok.nextElement().toString().equalsIgnoreCase(word)) contador++;
			}
			mapWords.put(word, contador);
		});	
		
		return mapWords;		
	}
}

package com.jr.scrap.processor.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessManager {
	@Autowired
	WordCounterManager wordCounterManager;
	
	public void run(String pPhrase, List<String> pUrls) {
		wordCounterManager.run(Arrays.asList(pPhrase.split(" ")),pUrls.get(0)).forEach((k,v) -> System.out.println("Palabra ".concat(k).concat(" valor ").concat(v.toString()))  ); ;
	}

}

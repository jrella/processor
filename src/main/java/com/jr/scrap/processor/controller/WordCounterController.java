package com.jr.scrap.processor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jr.scrap.processor.services.ProcessManager;

@RestController
public class WordCounterController {

	@Autowired
	ProcessManager processManager;
	
	@GetMapping(path = "/count")
	public String countWordsInSite() {
		List<String> urls = new ArrayList<>();
		urls.add("https://www.adictosaltrabajo.com/");
		
		processManager.run("Frontend", urls);
		return "Ok";
	}
}
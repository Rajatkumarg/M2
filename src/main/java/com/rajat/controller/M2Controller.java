package com.rajat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/m2")
public class M2Controller {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getDataM2/{data}")
	public String getDataM2(@PathVariable String data) {
		
		String toSendToM3 = data+" Bat";
		
		String url = "http://M3/m3/getDataM3/"+toSendToM3;
		
		data = restTemplate.getForObject(url, String.class);
		
		return "City is "+data;
	}
}

package com.shopping.cart.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableDiscoveryClient
public class CartController {
	
	@Autowired
	private RestTemplate restClient;
	
	@Autowired 
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/invokePayment")
	public String invokePayement() {
		
		final URI service = discoveryClient.getInstances("payment-service").stream().map(serviceURI->serviceURI.getUri())
				.findFirst().map(s->s.resolve("/pay")).get();
		return restClient.getForObject(service, String.class);
		
		
	}
	
	@Bean
	private RestTemplate getRestTemplate() {
	
		return new RestTemplate();
	}

}

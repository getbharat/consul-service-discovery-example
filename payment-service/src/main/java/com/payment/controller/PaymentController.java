package com.payment.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class PaymentController {

	@GetMapping("/pay")
	public String makePayment() {
		
		return "payment has processed";
		
	}	

}

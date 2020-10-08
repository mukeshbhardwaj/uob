package com.vendor.app.vendorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VendorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorserviceApplication.class, args);
	}

}

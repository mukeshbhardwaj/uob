package com.zuul.apigayway.zullapigatway.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.zuul.apigayway.zullapigatway.model.Vendors;

@FeignClient(name="http://VENDOR-SERVICE/v1/vendors")
public interface VendorFeignClient {

	@GetMapping("/test")
	public String test();
	
	
	  @GetMapping("/search/{id}") public ResponseEntity<Vendors>
	  searchItemById(@PathVariable("id") Long id);
	  
	  @GetMapping("/search/itemname") public ResponseEntity<List<Vendors>>
	  searchItemByName(@RequestParam("itemName") String itemName);
	 
	
}

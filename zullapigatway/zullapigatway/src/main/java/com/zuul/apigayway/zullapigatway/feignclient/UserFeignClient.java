package com.zuul.apigayway.zullapigatway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zuul.apigayway.zullapigatway.model.User;

@FeignClient(name="http://USER-SERVICE/users")
public interface UserFeignClient {

	@PostMapping("/register")
	public String registerUser(@RequestBody User user);
}

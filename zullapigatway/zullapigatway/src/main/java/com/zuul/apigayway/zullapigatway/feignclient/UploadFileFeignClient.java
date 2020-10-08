package com.zuul.apigayway.zullapigatway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name="http://VENDOR-SERVICE/upload")
public interface UploadFileFeignClient {

	 @GetMapping("/test")
	    public String index();
	 
	 @PostMapping("/excell")
	    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model);
}

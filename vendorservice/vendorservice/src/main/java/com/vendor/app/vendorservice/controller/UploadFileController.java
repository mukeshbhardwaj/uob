package com.vendor.app.vendorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vendor.app.vendorservice.service.impl.FileServicesImpl;



@RestController
@RequestMapping("/upload")
public class UploadFileController {
	
	@Autowired
	FileServicesImpl fileServices;
	
    @GetMapping("/test")
    public String index() {
    	
    	return "welcome to file upload controller";
    }
    
    @PostMapping("/excell")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			fileServices.store(file);
			model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		return "file upload success";
    }
}
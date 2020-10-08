package com.vendor.app.vendorservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vendor.app.vendorservice.model.Vendors;
import com.vendor.app.vendorservice.service.VendorService;

@RestController
@RequestMapping("/v1/vendors")
public class VendorController {

	@Autowired
	VendorService vendorService;

	@GetMapping("/test")
	public String test() {

		return "Welcome to Vendor Food App";
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Vendors> searchItemById(@PathVariable Long id) {
		Optional<Vendors> vendors = vendorService.find(id);
		if (vendors.isPresent()) {
			return new ResponseEntity<Vendors>(vendors.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Vendors>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/search/itemname")
	public ResponseEntity<List<Vendors>> searchItemByName(@RequestParam String itemName) {

		List<Vendors> vendors=null;
		try {
			vendors = vendorService.findByItemName(itemName);
			System.out.println("vendor list >>>"+vendors);
//			vendorsId = String.valueOf(vendors.gegetId());
		} catch (Exception ex) {
//			return "User not found: " + ex.toString();
		}

		return new ResponseEntity<List<Vendors>>(vendors,HttpStatus.OK);

	}

//	@GetMapping("/byvendorname")
//	public ResponseEntity<Vendors> getItemByVendors(@RequestParam Long id) {
//
//		return new ResponseEntity<Vendors>(HttpStatus.OK);
//	}

}

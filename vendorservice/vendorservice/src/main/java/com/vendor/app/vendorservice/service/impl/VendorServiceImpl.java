package com.vendor.app.vendorservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.app.vendorservice.model.Vendors;
import com.vendor.app.vendorservice.repo.VendorsRepository;
import com.vendor.app.vendorservice.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	VendorsRepository vendorsRepository;

	@Override
	public Optional<Vendors>  find(Long vendorId) {
		
		return vendorsRepository.findById(vendorId);
		
	}

	@Override
	public List<Vendors> findByItemName(String itemName) {
		 List<Vendors> vendorList=vendorsRepository.findByItem(itemName);
		 return vendorList;
	}

}

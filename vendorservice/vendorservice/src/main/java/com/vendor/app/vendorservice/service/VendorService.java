package com.vendor.app.vendorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vendor.app.vendorservice.model.Vendors;

@Service
public interface VendorService {

	public Optional<Vendors> find(Long vendorId);

	public List<Vendors> findByItemName(String itemName);

//	public VendorData findByItemName(String foodItem);

}

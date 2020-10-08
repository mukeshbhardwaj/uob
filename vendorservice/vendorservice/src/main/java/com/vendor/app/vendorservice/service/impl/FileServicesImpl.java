package com.vendor.app.vendorservice.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vendor.app.vendorservice.model.Vendors;
import com.vendor.app.vendorservice.repo.CustomerRepository;
import com.vendor.app.vendorservice.utils.ExcelUtils;

@Service
public class FileServicesImpl{
	
	@Autowired
	CustomerRepository customerRepository;
	
	// Store File Data to Database
	public void store(MultipartFile file){
		try {
			List<Vendors> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
    		// Save Customers to DataBase
    		customerRepository.saveAll(lstCustomers);
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	
	// Load Data to Excel File
    public ByteArrayInputStream loadFile() {
    	List<Vendors> customers = (List<Vendors>) customerRepository.findAll();
    	
    	try {
    		ByteArrayInputStream in = ExcelUtils.customersToExcel(customers);
    		return in;
		} catch (IOException e) {}
    	
        return null;
    }
}

package com.vendor.app.vendorservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendor.app.vendorservice.model.Vendors;

public interface VendorsRepository extends JpaRepository<Vendors, Long>{

	//this one is also working
//	@Query("from Vendors where item = :item")
//	List<Vendors> findByName( @Param("itemName") String itemName);
	
	
	//this one is also working
	public List<Vendors> findByItem(String item);
}

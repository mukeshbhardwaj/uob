package com.vendor.app.vendorservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.vendor.app.vendorservice.model.Vendors;

public interface CustomerRepository extends CrudRepository<Vendors, Long>{
}

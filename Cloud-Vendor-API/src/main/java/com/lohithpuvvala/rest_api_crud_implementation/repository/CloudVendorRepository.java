package com.lohithpuvvala.rest_api_crud_implementation.repository;

import com.lohithpuvvala.rest_api_crud_implementation.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    List<CloudVendor> findByVendorName(String name);
}

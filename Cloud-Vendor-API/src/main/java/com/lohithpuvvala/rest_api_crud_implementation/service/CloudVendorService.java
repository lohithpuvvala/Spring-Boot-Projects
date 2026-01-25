package com.lohithpuvvala.rest_api_crud_implementation.service;

import com.lohithpuvvala.rest_api_crud_implementation.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendorById(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
}

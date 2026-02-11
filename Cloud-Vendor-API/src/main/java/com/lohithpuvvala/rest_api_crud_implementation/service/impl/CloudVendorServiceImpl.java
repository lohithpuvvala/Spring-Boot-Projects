package com.lohithpuvvala.rest_api_crud_implementation.service.impl;

import com.lohithpuvvala.rest_api_crud_implementation.exception.CloudVendorNotFoundException;
import com.lohithpuvvala.rest_api_crud_implementation.model.CloudVendor;
import com.lohithpuvvala.rest_api_crud_implementation.repository.CloudVendorRepository;
import com.lohithpuvvala.rest_api_crud_implementation.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully created cloud vendor";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully updated cloud vendor";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Successfully deleted cloud vendor";
    }

    @Override
    public CloudVendor getCloudVendorById(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    public List<CloudVendor> findByVendorName(String vendorName) {
        return cloudVendorRepository.findByVendorName(vendorName);
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}

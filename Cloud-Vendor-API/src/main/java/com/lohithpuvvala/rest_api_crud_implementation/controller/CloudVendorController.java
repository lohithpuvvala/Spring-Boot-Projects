package com.lohithpuvvala.rest_api_crud_implementation.controller;

import com.lohithpuvvala.rest_api_crud_implementation.model.CloudVendor;
import com.lohithpuvvala.rest_api_crud_implementation.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Retrieve Cloud Vendor Details by vendorID
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.getCloudVendorById(vendorId);
    }
    //Retrieve All Cloud Vendor Details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    //Creates New Vendor Details
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    //Updates Vendor Details
    @PutMapping()
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    //Deletes Vendor Details
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}

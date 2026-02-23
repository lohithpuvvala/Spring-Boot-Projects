package com.lohithpuvvala.rest_api_crud_implementation.controller;

import com.lohithpuvvala.rest_api_crud_implementation.model.CloudVendor;
import com.lohithpuvvala.rest_api_crud_implementation.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;

    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor(
                "1", "Amazon", "USA", "xxxxx"
        );
        cloudVendorTwo = new CloudVendor(
                "2", "GCP", "UK", "yyyyy"
        );

        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendorById("1"))
                .thenReturn( cloudVendorOne );
        this.mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors())
                .thenReturn( cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendorDetails() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .disable(SerializationFeature.WRAP_ROOT_VALUE)
                .build();

        String requestJson = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne))
                .thenReturn("Successfully created cloud vendor");
        this.mockMvc.perform(post("/cloudvendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendorDetails() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .disable(SerializationFeature.WRAP_ROOT_VALUE)
                .build();

        String requestJson = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne))
                .thenReturn("Successfully updated cloud vendor");
        this.mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1"))
                .thenReturn("Successfully deleted cloud vendor");
        this.mockMvc.perform(delete("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}
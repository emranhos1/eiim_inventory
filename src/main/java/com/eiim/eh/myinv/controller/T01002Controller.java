package com.eiim.eh.myinv.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiim.eh.myinv.entity.T01002;
import com.eiim.eh.myinv.service.T01002Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@RestController
@RequestMapping("/api/v1.0/vendor")
public class T01002Controller {

    @Autowired
    T01002Service t01002Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01002> allVendorDetails = t01002Service.findAll();
        int total = allVendorDetails.size();
        if(!CollectionUtils.isEmpty(allVendorDetails)){
            response.put("data", allVendorDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allVendorDetails) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allVendorDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{vendorCode}")
    public Map<String, Object> findByCode(@PathVariable("vendorCode") int vendorCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01002 vendorDetails = t01002Service.findByVendorCode(vendorCode);
        if(!ObjectUtils.isEmpty(vendorDetails)){
            response.put("data", vendorDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(vendorDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(vendorDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(vendorDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01002 t01002) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", t01002.getVendorEmail());

        T01002 emailSearch = t01002Service.findByEmail(params);
        if(ObjectUtils.isEmpty(emailSearch)){
            t01002.setIsActive(1);
            t01002.setEntryDate(new Date());
            T01002 responseData = t01002Service.insert(t01002);
            if (!ObjectUtils.isEmpty(responseData)) {
                response.put("date", responseData);
            } else {
                response.put("date", null);
            }

            response.put("total", ObjectUtils.isEmpty(responseData) ? 0 : 1);
            response.put("success", ObjectUtils.isEmpty(responseData) ? false : true);
            response.put("message", ObjectUtils.isEmpty(responseData) ? "No Record Save" : "One Records Saved");
        } else {
            response.put("success", false);
            response.put("message", "Email Already Exist Please Try Another One!");
        }

        return response;
    }

    @PutMapping("/{vendorCode}")
    public Map<String, Object> updateByPatno(@PathVariable("vendorCode") int vendorCode, @RequestBody T01002 t01002) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(vendorCode)){
            t01002.setVendorId(vendorCode);
            T01002 getDetails = t01002Service.findByVendorCode(vendorCode);

            t01002.setIsActive(getDetails.getIsActive());
            t01002.setEntryDate(getDetails.getEntryDate());
            t01002.setUpdateDate(new Date());
            T01002 responseData = t01002Service.update(t01002);
            if (!ObjectUtils.isEmpty(responseData)) {
                response.put("data", responseData);
                response.put("total", 1);
                response.put("success", true);
                response.put("message", "Record Updared");
            } else {
                response.put("data", null);
                response.put("total", total);
                response.put("success", false);
                response.put("message", "Record Not Updated");
            }
        } else {
            response.put("success", false);
            response.put("message", "Give User Id For Update");
        }

        return response;
    }
}

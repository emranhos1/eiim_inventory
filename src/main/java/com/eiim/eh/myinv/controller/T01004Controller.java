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
import org.springframework.web.bind.annotation.*;

import com.eiim.eh.myinv.entity.T01004;
import com.eiim.eh.myinv.service.T01004Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T03:33:00
 */
@RestController
@RequestMapping("/api/v1.0/distributor")
public class T01004Controller {

    @Autowired
    T01004Service t01004Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01004> allUserDetails = t01004Service.findAll();
        int total = allUserDetails.size();
        if(!CollectionUtils.isEmpty(allUserDetails)){
            response.put("data", allUserDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allUserDetails) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allUserDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{distributorCode}")
    public Map<String, Object> findByCode(@PathVariable("distributorCode") int distributorCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01004 distributorDetails = t01004Service.findBydistributorId(distributorCode);
        if(!ObjectUtils.isEmpty(distributorDetails)){
            response.put("data", distributorDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(distributorDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(distributorDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(distributorDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01004 t01004) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", t01004.getDistributorEmail());

        T01004 emailSearch = t01004Service.findByEmail(params);
        if(ObjectUtils.isEmpty(emailSearch)){
            t01004.setIsActive(1);
            t01004.setEntryDate(new Date());
            T01004 data = t01004Service.insert(t01004);
            if (!ObjectUtils.isEmpty(data)) {
                response.put("date", data);
            } else {
                response.put("date", null);
            }

            response.put("total", ObjectUtils.isEmpty(data) ? 0 : 1);
            response.put("success", ObjectUtils.isEmpty(data) ? false : true);
            response.put("message", ObjectUtils.isEmpty(data) ? "No Record Save" : "One Records Saved");
        } else {
            response.put("success", false);
            response.put("message", "Email Already Exist Please Try Another One!");
        }

        return response;
    }

    @PutMapping("/{distributorCode}")
    public Map<String, Object> updateByPatno(@PathVariable("distributorCode") int distributorCode, @RequestBody T01004 t01004) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(distributorCode)){
            t01004.setDistributorId(distributorCode);
            T01004 getDetails = t01004Service.findBydistributorId(distributorCode);

            t01004.setIsActive(getDetails.getIsActive());
            t01004.setEntryDate(getDetails.getEntryDate());
            t01004.setUpdateDate(new Date());
            T01004 responseData = t01004Service.update(t01004);
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

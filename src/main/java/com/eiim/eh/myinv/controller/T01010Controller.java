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

import com.eiim.eh.myinv.entity.T01010;
import com.eiim.eh.myinv.pojo.T01010Pojo;
import com.eiim.eh.myinv.service.T01010Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-21T10:28:00
 */
@RestController
@RequestMapping("/rest/v1.0/make_payment")
public class T01010Controller {

    @Autowired
    T01010Service t01010Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01010Pojo> allMakePayment = t01010Service.findAll();
        int total = allMakePayment.size();
        if(!CollectionUtils.isEmpty(allMakePayment)){
            response.put("data", allMakePayment);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allMakePayment) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allMakePayment) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{makePaymentCode}")
    public Map<String, Object> findByCode(@PathVariable("makePaymentCode") int makePaymentCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01010Pojo makePaymentDetails = t01010Service.findById(makePaymentCode);
        if(!ObjectUtils.isEmpty(makePaymentCode)){
            response.put("data", makePaymentDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(makePaymentDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(makePaymentDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(makePaymentDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01010 t01010) {
        Map<String, Object> response = new HashMap<String, Object>();

        t01010.setIsActive(1);
        t01010.setEntryDate(new Date());
        T01010 data = t01010Service.insert(t01010);
        if (!ObjectUtils.isEmpty(data)) {
            response.put("date", data);
        } else {
            response.put("date", null);
        }

        response.put("total", ObjectUtils.isEmpty(data) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(data) ? false : true);
        response.put("message", ObjectUtils.isEmpty(data) ? "No Record Save" : "One Records Saved");

        return response;
    }

    @PutMapping("/{makePaymentCode}")
    public Map<String, Object> updateByPatno(@PathVariable("makePaymentCode") int makePaymentCode, @RequestBody T01010 t01010) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(makePaymentCode)){
            t01010.setMakePaymentId(makePaymentCode);
            T01010Pojo getDetails = t01010Service.findById(makePaymentCode);

            t01010.setIsActive(getDetails.getIsActive());
            t01010.setEntryDate(getDetails.getEntryDate());
            t01010.setUpdateDate(new Date());
            T01010 responseData = t01010Service.update(t01010);
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

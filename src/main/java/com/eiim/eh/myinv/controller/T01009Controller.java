package com.eiim.eh.myinv.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiim.eh.myinv.entity.T01009;
import com.eiim.eh.myinv.service.T01009Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-21T10:28:00
 */
@RestController
@RequestMapping("/rest/v1.0/payment_type")
public class T01009Controller {

    @Autowired
    T01009Service t01009Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01009> allpaymentType = t01009Service.findAll();
        int total = allpaymentType.size();
        if(!CollectionUtils.isEmpty(allpaymentType)){
            response.put("data", allpaymentType);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allpaymentType) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allpaymentType) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{paymentTypeCode}")
    public Map<String, Object> findByCode(@PathVariable("paymentTypeCode") int paymentTypeCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01009 paymentTypeDetails = t01009Service.findById(paymentTypeCode);
        if(!ObjectUtils.isEmpty(paymentTypeDetails)){
            response.put("data", paymentTypeDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(paymentTypeDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(paymentTypeDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(paymentTypeDetails) ? "No Record Found" : "Records Found");

        return response;
    }
}

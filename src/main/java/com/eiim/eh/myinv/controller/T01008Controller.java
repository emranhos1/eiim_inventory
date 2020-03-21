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

import com.eiim.eh.myinv.entity.T01008;
import com.eiim.eh.myinv.service.T01008Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-21T10:28:00
 */
@RestController
@RequestMapping("/rest/v1.0/payment_method")
public class T01008Controller {

    @Autowired
    T01008Service t01008Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01008> allpaymentMethod = t01008Service.findAll();
        int total = allpaymentMethod.size();
        if(!CollectionUtils.isEmpty(allpaymentMethod)){
            response.put("data", allpaymentMethod);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allpaymentMethod) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allpaymentMethod) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{paymentMethodCode}")
    public Map<String, Object> findByCode(@PathVariable("paymentMethodCode") int paymentMethodCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01008 paymentMethod = t01008Service.findById(paymentMethodCode);
        if(!ObjectUtils.isEmpty(paymentMethod)){
            response.put("data", paymentMethod);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(paymentMethod) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(paymentMethod) ? false : true);
        response.put("message", ObjectUtils.isEmpty(paymentMethod) ? "No Record Found" : "Records Found");

        return response;
    }
}

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

import com.eiim.eh.myinv.entity.T01011;
import com.eiim.eh.myinv.pojo.T01011Pojo;
import com.eiim.eh.myinv.service.T01011Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-21T10:28:00
 */
@RestController
@RequestMapping("/rest/v1.0/receive_payment")
public class T01011Controller {

    @Autowired
    T01011Service t01011Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01011Pojo> allReceivePayment = t01011Service.findAll();
        int total = allReceivePayment.size();
        if(!CollectionUtils.isEmpty(allReceivePayment)){
            response.put("data", allReceivePayment);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allReceivePayment) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allReceivePayment) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{receivePaymentCode}")
    public Map<String, Object> findByCode(@PathVariable("receivePaymentCode") int receivePaymentCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01011Pojo makePaymentDetails = t01011Service.findById(receivePaymentCode);
        if(!ObjectUtils.isEmpty(receivePaymentCode)){
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
    public Map<String, Object> create(@RequestBody T01011 t01011) {
        Map<String, Object> response = new HashMap<String, Object>();

        t01011.setIsActive(1);
        t01011.setEntryDate(new Date());
        T01011 data = t01011Service.insert(t01011);
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

    @PutMapping("/{receivePaymentCode}")
    public Map<String, Object> updateByPatno(@PathVariable("receivePaymentCode") int receivePaymentCode, @RequestBody T01011 t01011) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(receivePaymentCode)){
            t01011.setReceivePaymentId(receivePaymentCode);
            T01011Pojo getDetails = t01011Service.findById(receivePaymentCode);

            t01011.setIsActive(getDetails.getIsActive());
            t01011.setEntryDate(getDetails.getEntryDate());
            t01011.setUpdateDate(new Date());
            T01011 responseData = t01011Service.update(t01011);
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

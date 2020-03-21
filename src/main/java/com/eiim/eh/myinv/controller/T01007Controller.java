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

import com.eiim.eh.myinv.entity.T01007;
import com.eiim.eh.myinv.pojo.T01007Pojo;
import com.eiim.eh.myinv.service.T01007Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-21T10:28:00
 */
@RestController
@RequestMapping("/api/v1.0/order")
public class T01007Controller {

    @Autowired
    T01007Service t01007Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01007Pojo> allShipment = t01007Service.findAll();
        int total = allShipment.size();
        if(!CollectionUtils.isEmpty(allShipment)){
            response.put("data", allShipment);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allShipment) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allShipment) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{orderCode}")
    public Map<String, Object> findByCode(@PathVariable("orderCode") int orderCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01007Pojo orderDetails = t01007Service.findById(orderCode);
        if(!ObjectUtils.isEmpty(orderDetails)){
            response.put("data", orderDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(orderDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(orderDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(orderDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01007 t01007) {
        Map<String, Object> response = new HashMap<String, Object>();

        t01007.setIsActive(1);
        t01007.setEntryDate(new Date());
        T01007 data = t01007Service.insert(t01007);
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

    @PutMapping("/{orderCode}")
    public Map<String, Object> updateByPatno(@PathVariable("orderCode") int orderCode, @RequestBody T01007 t01007) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(orderCode)){
            t01007.setOrderId(orderCode);
            T01007 getDetails = t01007Service.findByShipmentId(orderCode);

            t01007.setIsActive(getDetails.getIsActive());
            t01007.setEntryDate(getDetails.getEntryDate());
            t01007.setUpdateDate(new Date());
            T01007 responseData = t01007Service.update(t01007);
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

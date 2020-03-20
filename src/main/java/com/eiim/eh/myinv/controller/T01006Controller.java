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

import com.eiim.eh.myinv.entity.T01006;
import com.eiim.eh.myinv.pojo.T01006Pojo;
import com.eiim.eh.myinv.service.T01006Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@RestController
@RequestMapping("/api/v1.0/shipment")
public class T01006Controller {

    @Autowired
    T01006Service t01006Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01006Pojo> allShipment = t01006Service.findAll();
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

    @GetMapping("/{shipmentCode}")
    public Map<String, Object> findByCode(@PathVariable("shipmentCode") int shipmentCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01006Pojo shipmentDetails = t01006Service.findById(shipmentCode);
        if(!ObjectUtils.isEmpty(shipmentDetails)){
            response.put("data", shipmentDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(shipmentDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(shipmentDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(shipmentDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01006 t01006) {
        Map<String, Object> response = new HashMap<String, Object>();

        t01006.setIsActive(1);
        t01006.setEntryDate(new Date());
        T01006 data = t01006Service.insert(t01006);
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

    @PutMapping("/{shipmentCode}")
    public Map<String, Object> updateByPatno(@PathVariable("shipmentCode") int shipmentCode, @RequestBody T01006 t01006) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(shipmentCode)){
            t01006.setShipmentId(shipmentCode);
            T01006 getDetails = t01006Service.findByShipmentId(shipmentCode);

            t01006.setIsActive(getDetails.getIsActive());
            t01006.setEntryDate(getDetails.getEntryDate());
            t01006.setUpdateDate(new Date());
            T01006 responseData = t01006Service.update(t01006);
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

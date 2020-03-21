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

import com.eiim.eh.myinv.entity.T01005;
import com.eiim.eh.myinv.service.T01005Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@RestController
@RequestMapping("/rest/v1.0/transport")
public class T01005Controller {

    @Autowired
    T01005Service t01005Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01005> allRole = t01005Service.findAll();
        int total = allRole.size();
        if(!CollectionUtils.isEmpty(allRole)){
            response.put("data", allRole);
        } else {
            response.put("data", null);
        }

        response.put("total", total);
        response.put("success", CollectionUtils.isEmpty(allRole) ? false : true);
        response.put("message", CollectionUtils.isEmpty(allRole) ? "No Record Found" : "Records Found");

        return response;
    }

    @GetMapping("/{transportCode}")
    public Map<String, Object> findByCode(@PathVariable("transportCode") int transportCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01005 transportDetails = t01005Service.findById(transportCode);
        if(!ObjectUtils.isEmpty(transportDetails)){
            response.put("data", transportDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(transportDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(transportDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(transportDetails) ? "No Record Found" : "Records Found");

        return response;
    }
}

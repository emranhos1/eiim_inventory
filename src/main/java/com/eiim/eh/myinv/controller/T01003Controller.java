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

import com.eiim.eh.myinv.entity.T01003;
import com.eiim.eh.myinv.service.T01003Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@RestController
@RequestMapping("/rest/v1.0/role")
public class T01003Controller {

    @Autowired
    T01003Service t01003Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01003> allRole = t01003Service.findAll();
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

    @GetMapping("/{vendorCode}")
    public Map<String, Object> findByCode(@PathVariable("vendorCode") int vendorCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01003 roleDetails = t01003Service.findByRoleId(vendorCode);
        if(!ObjectUtils.isEmpty(roleDetails)){
            response.put("data", roleDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(roleDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(roleDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(roleDetails) ? "No Record Found" : "Records Found");

        return response;
    }
}

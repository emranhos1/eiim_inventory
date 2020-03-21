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

import com.eiim.eh.myinv.entity.T01001;
import com.eiim.eh.myinv.pojo.T01001Pojo;
import com.eiim.eh.myinv.service.T01001Service;

/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@RestController
@RequestMapping("/rest/v1.0/user")
public class T01001Controller {

    @Autowired
    T01001Service t01001Service;

    @GetMapping
    public Map<String, Object> findAll() throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        List<T01001Pojo> allUserDetails = t01001Service.findAll();
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

    @GetMapping("/{userCode}")
    public Map<String, Object> findByCode(@PathVariable("userCode") int userCode) throws IOException {
        Map<String, Object> response = new HashMap<String, Object>();

        T01001Pojo UserDetails = t01001Service.findByUserCode(userCode);
        if(!ObjectUtils.isEmpty(UserDetails)){
            response.put("data", UserDetails);
        } else {
            response.put("data", null);
        }

        response.put("total", ObjectUtils.isEmpty(UserDetails) ? 0 : 1);
        response.put("success", ObjectUtils.isEmpty(UserDetails) ? false : true);
        response.put("message", ObjectUtils.isEmpty(UserDetails) ? "No Record Found" : "Records Found");

        return response;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody T01001 t01001) {
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", t01001.getEmail());

        T01001 emailSearch = t01001Service.findByEmail(params);
        if(ObjectUtils.isEmpty(emailSearch)){
            t01001.setIsActive(1);
            t01001.setEntryDate(new Date());
            T01001 data = t01001Service.insert(t01001);
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

    @PutMapping("/{userCode}")
    public Map<String, Object> updateByPatno(@PathVariable("userCode") int userCode, @RequestBody T01001 t01001) {
        Map<String, Object> response = new HashMap<String, Object>();
        int total = 0;

        if(!StringUtils.isEmpty(userCode)){
            t01001.setUserId(userCode);
            T01001 getDetails = t01001Service.findByUserId(userCode);

            t01001.setIsActive(getDetails.getIsActive());
            t01001.setEntryDate(getDetails.getEntryDate());
            t01001.setUpdateDate(new Date());
            T01001 responseData = t01001Service.update(t01001);
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

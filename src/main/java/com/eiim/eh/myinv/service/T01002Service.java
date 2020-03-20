package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import com.eiim.eh.myinv.entity.T01002;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
public interface T01002Service {

    List<T01002> findAll();
    T01002 findByVendorCode(int vendorCode);
    T01002 findByEmail(Map<String, Object> params);
    T01002 insert(T01002 t01002);
    T01002 update(T01002 t01002);
}

package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import com.eiim.eh.myinv.entity.T01001;
import com.eiim.eh.myinv.pojo.T01001Pojo;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
public interface T01001Service {

    List<T01001Pojo> findAll();
    T01001Pojo findByUserCode(int userCode);
    T01001 findByUserId(int userCode);
    T01001 findByEmail(Map<String, Object> params);
    T01001 insert(T01001 t01001);
    T01001 update(T01001 t01001);
}

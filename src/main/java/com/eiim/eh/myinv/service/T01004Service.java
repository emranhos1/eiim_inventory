package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import com.eiim.eh.myinv.entity.T01004;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T03:33:00
 */
public interface T01004Service {

    List<T01004> findAll();
    T01004 findBydistributorId(int distributorCode);
    T01004 findByEmail(Map<String, Object> params);
    T01004 insert(T01004 t01004);
    T01004 update(T01004 t01004);
}

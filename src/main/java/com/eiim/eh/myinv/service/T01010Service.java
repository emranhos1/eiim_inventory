package com.eiim.eh.myinv.service;

import java.util.List;

import com.eiim.eh.myinv.entity.T01010;
import com.eiim.eh.myinv.pojo.T01010Pojo;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
public interface T01010Service {

    List<T01010Pojo> findAll();
    T01010Pojo findById(int makePaymentCode);
    T01010 insert(T01010 t01010);
    T01010 update(T01010 t01010);
}

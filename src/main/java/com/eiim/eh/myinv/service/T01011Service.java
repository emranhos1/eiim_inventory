package com.eiim.eh.myinv.service;

import java.util.List;

import com.eiim.eh.myinv.entity.T01011;
import com.eiim.eh.myinv.pojo.T01011Pojo;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
public interface T01011Service {

    List<T01011Pojo> findAll();
    T01011Pojo findById(int receivePaymentCode);
    T01011 insert(T01011 t01011);
    T01011 update(T01011 t01011);
}

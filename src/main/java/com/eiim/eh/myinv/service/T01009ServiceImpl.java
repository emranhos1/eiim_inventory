package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01009;
import com.eiim.eh.myinv.repository.T01009Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01009ServiceImpl implements T01009Service {

    @Autowired
    T01009Repository t01009Repository;

    @Override
    public List<T01009> findAll() {
        return t01009Repository.findAll();
    }

    @Override
    public T01009 findById(int paymentTypeCode) {
        return t01009Repository.findByPaymentTypeId(paymentTypeCode);
    }
}

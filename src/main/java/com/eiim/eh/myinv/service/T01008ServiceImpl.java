package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01008;
import com.eiim.eh.myinv.repository.T01008Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01008ServiceImpl implements T01008Service {

    @Autowired
    T01008Repository t01008Repository;

    @Override
    public List<T01008> findAll() {
        return t01008Repository.findAll();
    }

    @Override
    public T01008 findById(int paymentCode) {
        return t01008Repository.findByPaymentMethodId(paymentCode);
    }
}

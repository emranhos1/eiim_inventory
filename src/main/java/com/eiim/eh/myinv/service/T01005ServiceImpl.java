package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01005;
import com.eiim.eh.myinv.repository.T01005Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Service
public class T01005ServiceImpl implements T01005Service {

    @Autowired
    T01005Repository t01005Repository;

    @Override
    public List<T01005> findAll() {
        return t01005Repository.findAll();
    }

    @Override
    public T01005 findById(int transportCode) {
        return t01005Repository.findByTransportId(transportCode);
    }
}

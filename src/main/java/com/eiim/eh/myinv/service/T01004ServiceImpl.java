package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01004;
import com.eiim.eh.myinv.repository.T01004Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T03:33:00
 */
@Service
public class T01004ServiceImpl implements T01004Service {

    @Autowired
    T01004Repository t01004Repository;

    @Override
    public List<T01004> findAll() {
        return t01004Repository.findAll();
    }

    @Override
    public T01004 findBydistributorId(int distributorCode) {
        return t01004Repository.findByDistributorId(distributorCode);
    }

    @Override
    public T01004 findByEmail(Map<String, Object> params) {
        String email = params.get("email").toString();
        return t01004Repository.findByDistributorEmail(email);
    }

    @Override
    public T01004 insert(T01004 T01004) {
        return t01004Repository.save(T01004);
    }

    @Override
    public T01004 update(T01004 T01004) {
        return t01004Repository.save(T01004);
    }
}

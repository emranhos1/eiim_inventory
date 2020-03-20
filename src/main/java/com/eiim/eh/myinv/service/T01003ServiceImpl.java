package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01003;
import com.eiim.eh.myinv.repository.T01003Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Service
public class T01003ServiceImpl implements T01003Service {

    @Autowired
    T01003Repository t01003Repository;

    @Override
    public List<T01003> findAll() {
        return t01003Repository.findAll();
    }

    @Override
    public T01003 findByRoleId(int roleId) {
        return t01003Repository.findByRoleId(roleId);
    }
}

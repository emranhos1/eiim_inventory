package com.eiim.eh.myinv.service;

import java.util.List;

import com.eiim.eh.myinv.entity.T01003;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
public interface T01003Service {

    List<T01003> findAll();
    T01003 findByRoleId(int roleId);
}

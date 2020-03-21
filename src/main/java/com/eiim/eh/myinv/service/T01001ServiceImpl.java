package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01001;
import com.eiim.eh.myinv.pojo.T01001Pojo;
import com.eiim.eh.myinv.repository.T01001Repository;
import com.eiim.eh.myinv.util.T01001RowMapper;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Service
public class T01001ServiceImpl implements T01001Service {

    @Autowired
    T01001Repository t01001Repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<T01001Pojo> findAll() {
        //return t01001Repository.findAll();
        String sql = "SELECT u.*, r.t_role_id, r.t_role_name "
                   + "FROM T01001 u LEFT JOIN T01003 r "
                   + "ON (u.t_role_id = r.t_role_id)";
        return jdbcTemplate.query( sql, new T01001RowMapper());
    }

    @Override
    public T01001Pojo findByUserCode(int userCode) {
        //return t01001Repository.findByUserId(userCode);
        String sql = "SELECT u.*, r.t_role_id, r.t_role_name "
                   + "FROM T01001 u LEFT JOIN T01003 r "
                   + "ON (u.t_role_id = r.t_role_id) "
                   + "WHERE u.t_user_id = ?";
        return (T01001Pojo) jdbcTemplate.queryForObject(sql, new Object[]{userCode}, new T01001RowMapper());
    }


    @Override
    public T01001 findByUserId(int userCode) {
        return t01001Repository.findByUserId(userCode);
    }

    @Override
    public T01001 findByEmail(Map<String, Object> params) {
        String email = params.get("email").toString();
        return t01001Repository.findByEmail(email);
    }

    @Override
    public T01001 insert(T01001 t01001) {
        return t01001Repository.save(t01001);
    }

    @Override
    public T01001 update(T01001 t01001) {
        return t01001Repository.save(t01001);
    }
}

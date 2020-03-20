package com.eiim.eh.myinv.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01002;
import com.eiim.eh.myinv.repository.T01002Repository;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Service
public class T01002ServiceImpl implements T01002Service {

    @Autowired
    T01002Repository t01002Repository;

    @Override
    public List<T01002> findAll() {
        return t01002Repository.findAll();
    }

    @Override
    public T01002 findByVendorCode(int vendorCode) {
        return t01002Repository.findByVendorId(vendorCode);
    }

    @Override
    public T01002 findByEmail(Map<String, Object> params) {
        String email = params.get("email").toString();
        return t01002Repository.findByVendorEmail(email);
    }

    @Override
    public T01002 insert(T01002 t01002) {
        return t01002Repository.save(t01002);
    }

	@Override
	public T01002 update(T01002 t01002) {
		return t01002Repository.save(t01002);
	}
}

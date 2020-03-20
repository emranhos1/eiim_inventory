package com.eiim.eh.myinv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiim.eh.myinv.entity.T01001;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Repository
public interface T01001Repository extends JpaRepository<T01001, Integer>{

    T01001 findByUserId(int userCode);
    T01001 findByEmail(String email);
}

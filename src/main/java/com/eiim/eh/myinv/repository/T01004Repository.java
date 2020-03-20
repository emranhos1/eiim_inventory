package com.eiim.eh.myinv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiim.eh.myinv.entity.T01004;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T03:33:00
 */
@Repository
public interface T01004Repository extends JpaRepository<T01004, Integer>{

    T01004 findByDistributorId(int userCode);
    T01004 findByDistributorEmail(String email);
}

package com.eiim.eh.myinv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiim.eh.myinv.entity.T01005;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-19T09:11:00
 */
@Repository
public interface T01005Repository extends JpaRepository<T01005, Integer>{

    T01005 findByTransportId(int transportCode);
}

package com.sbcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbcrm.entity.Cust;

public interface UserRepository extends JpaRepository<Cust, Integer>{

}

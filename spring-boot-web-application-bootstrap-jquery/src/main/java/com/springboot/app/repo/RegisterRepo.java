package com.springboot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entity.Registration;

@Repository
public interface RegisterRepo extends JpaRepository<Registration, Long> {

}

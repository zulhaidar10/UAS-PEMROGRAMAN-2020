/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.repository;

import com.northwind.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fnauf
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.repository;

import com.northwind.jpa.entity.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fnauf
 */
public interface ShippersRepository extends JpaRepository<Shippers, Integer>{
    
}

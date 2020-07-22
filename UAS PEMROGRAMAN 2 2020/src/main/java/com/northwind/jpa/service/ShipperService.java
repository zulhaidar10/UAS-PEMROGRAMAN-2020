/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.service;

import com.northwind.jpa.entity.Customers;
import com.northwind.jpa.entity.Shippers;
import com.northwind.jpa.repository.ShippersRepository;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author fnauf
 */

@Service
public class ShipperService implements RepoService<Shippers>{
    @Resource
    private ShippersRepository repo;
    
    @Override
    public Shippers create(Shippers obj) {
        Shippers cus = repo.save(obj);
        return cus;
    }

    @Override
    public Shippers update(Shippers obj) {
        Shippers Shipper = repo.findById(obj.getShipperID()).orElse(null);
        if (Shipper != null) { 
            Shipper.setCompanyName(obj.getCompanyName());
            repo.flush();
            return obj;
        } else {
            throw new NoSuchElementException("Data not found!");
        }
    }

    @Override
    public Shippers delete(Object id) {
        Shippers Shipper = repo.findById(Integer.valueOf(id.toString())).orElse(null);
        if (Shipper != null) {
            repo.delete(Shipper);
            return Shipper;
        } else {
            throw new NoSuchElementException("Data not found!");
        }
    }

    @Override
    public Shippers getById(Object id) {
        
        Shippers Shipper = repo.findById(Integer.valueOf(id.toString())).orElse(null);
        return Shipper;
    }

    @Override
    public List<Shippers> getAll() {
        return repo.findAll();
    }
    
    public Page<Shippers> getByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAll(pageable);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.service;

import com.northwind.jpa.entity.User;
import com.northwind.jpa.entity.User;
import com.northwind.jpa.repository.UserRepository;
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
public class UserService implements RepoService<User> {
      @Resource
      
      private UserRepository repo;
      
      @Override
    public User create(User obj) {
        User cus = repo.save(obj);
        return cus;
    }

    @Override
    public User update(User obj) {
        User user = repo.findById(obj.getUserID()).orElse(null);
        if (user != null) { 
            user.setName(obj.getName());
            
             
            repo.flush();
            return obj;
        } else {
            throw new NoSuchElementException("Data not found!");
        }
    }

    @Override
    public User delete(Object id) {
        User user = repo.findById(Integer.valueOf(id.toString())).orElse(null);
        if (user != null) {
            repo.delete(user);
            return user;
        } else {
            throw new NoSuchElementException("Data not found!");
        }
    }

    @Override
    public User getById(Object id) {
        User user = repo.findById(Integer.valueOf(id.toString())).orElse(null);
        return user;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }
    
    public Page<User> getByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repo.findAll(pageable);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.controller;

import com.northwind.jpa.entity.Products;
import com.northwind.jpa.entity.response.ApiResponse;
import com.northwind.jpa.service.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fnauf
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
    
    @Autowired
    private ProductsServices services;
    
    @GetMapping("")
    public ApiResponse getAll(
            @RequestParam(defaultValue = "1")int page, 
            @RequestParam(defaultValue = "10")int pageSize, 
            @RequestParam(defaultValue = "", required = false)String search, 
            @RequestParam(defaultValue = "productID", required = false)String sort, 
            @RequestParam(defaultValue = "true", required = false)boolean asc){
        try {
            String param = "%" + search + "%";
            Page<Products> result = services.getByPage(page - 1, pageSize, param, sort, asc);
            return ApiResponse.ok(result);
        } catch (Exception e) {
            return ApiResponse.internalServerError(e.getMessage());
        }
        
    }
    
    @GetMapping("/(id)")
    public ApiResponse getById(@PathVariable("id") int id){
        try {
            Products prod = services.getById(id);
            if(prod == null){
            return ApiResponse.notFound("Data Tidak Ditemukan");
        }
            return ApiResponse.ok(prod);
        } catch (Exception e) {
            return ApiResponse.internalServerError(e.getMessage());
        }
    }
    
    @PostMapping("")
    public ApiResponse create(@RequestBody Products prod){
        try {
            Products result = services.create(prod);
            return ApiResponse.created("Create Pruduct Succses");
        } catch (Exception e) {
            return ApiResponse.internalServerError(e.getMessage());
        }
    }
    
    @PutMapping("")
    public ApiResponse update(@RequestBody Products prod){
        try {
            Products result = services.update(prod);
            return ApiResponse.accepted("Update Pruduct Succses");
        } catch (Exception e) {
            return ApiResponse.internalServerError(e.getMessage());
        }
    }
    
    @DeleteMapping("/(id)")
    public ApiResponse delete(@PathVariable("id") int id){
        try {
            Products result = services.delete(id);
            return ApiResponse.ok("Delete Pruduct Succses");
        } catch (Exception e) {
            return ApiResponse.internalServerError(e.getMessage());
        }
    }
}

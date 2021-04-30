package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> Admins = new ArrayList<>();

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmins() {
        return Admins;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        
        Admins.add(admin);
        
        return admin;
    }

    @GetMapping("/search")
    public ArrayList<Admin> searchAdmin(@RequestParam String username){
        ArrayList<Admin> ad = new ArrayList<>();
        boolean f = false;

        for(Admin a: Admins){
            if(a.getUsername().equals(username)){
                f = true;
                ad.add(a);
            }              
        }
        if(f==true) return ad;
        else return null;
    }

    // // http://localhost:8080/test/hello/xfactor
    // @GetMapping("/hello/{name}")
    // @ResponseBody
    // public String index_greetings(@PathVariable String name) {
    // return "Greetings :" + name;
    // }

    // // http://localhost:8080/test/hello2?id=16
    // @GetMapping("/hello2")
    // @ResponseBody
    // public String getFoos(@RequestParam String id) {
    // return "ID: " + id;
    // }

    // @PostMapping("/employees")
    // Employee newEmployee(@RequestBody Employee newEmployee) {
    // return repository.save(newEmployee);
    // }

}

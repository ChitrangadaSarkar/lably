package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.entity.Tests;
import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.entity.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/test")
public class TestController {

    ArrayList<Lab> labs = new ArrayList<>();

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "Greetings from XFACTOR!!!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Greetings from " + name + "!!!";
    }

    @GetMapping("/hello2")
    public String helloName2(@RequestParam String name, @RequestParam String age) {
        return "Greetings from hello2 " + name + "!!!" + age;
    }

    @GetMapping("/hello3")
    public Map<String, String> helloName3(@RequestParam String name, @RequestParam String age) {
        Map<String, String> respoMap = new HashMap<>();
        respoMap.put("name", name);
        respoMap.put("age", age);
        return respoMap;
    }

    @GetMapping("/hello4")
    public ArrayList helloName4(@RequestParam String name, @RequestParam String age) {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(name);
        arrayList.add(age);
        return arrayList;
    }

    @GetMapping("/getLabs")
    public ArrayList<Lab> getLabs() {
        return labs;
    }

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {
        String name = lab.getName();
        String address = lab.getAddress();
        String phone = lab.getPhone();
        String pincode = lab.getPincode();
        name = "NAME - " + name + "\n";
        address = "ADDRESS - " + address + "\n";
        phone = "PHONE - " + phone + "\n";
        pincode = "PINCODE - " + pincode + "\n";
        lab.setName(name);
        lab.setAddress(address);
        lab.setPhone(phone);
        lab.setPincode(pincode);
        labs.add(lab);
        return lab;
    }

   /* @PostMapping("/addTests")
    public Tests addLab(@RequestBody Tests tests) {
        String name = lab.getName();
        name = "NAME - " + name + "\n";
        lab.setName(name);
        //labs.add(lab);
        return lab;
    }

    @PostMapping("/addAdmin")
    public Lab addLab(@RequestBody Lab lab) {
        String name = lab.getName();
        name = "Hello " + name + "\n";
        address = "";
       // lab.setName(name);
       // labs.add(lab);
       // return lab;
    }
    @PostMapping("/addCustomer")
    public Lab addLab(@RequestBody Lab lab) {
        String name = lab.getName();
        name = "Hello " + name;
        lab.setName(name);
        labs.add(lab);
        return lab;
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
    // }*/

}

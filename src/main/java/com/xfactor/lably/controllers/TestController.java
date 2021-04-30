package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.entity.Lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    ArrayList<Lab> labs = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    
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
    public ArrayList<String> helloName4(@RequestParam String name, @RequestParam String age) {
        ArrayList<String> arrayList = new ArrayList<>();
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
        labs.add(lab);
        return lab;
    }

    @GetMapping("/findLab")
    public Lab findLab(@RequestParam String name) {
        Lab slab = new Lab();
        for(Lab lab : labs) {
            if( name.equals(lab.getName()) ) slab = lab;
        }
        return slab;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    @GetMapping("/findAdmin")
    public Admin findAdmin(@RequestParam String name) {
        Admin sadmin = new Admin();
        for(Admin admin : admins) {
            if( name.equals(admin.getName()) ) sadmin = admin;
        }
        return sadmin;
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

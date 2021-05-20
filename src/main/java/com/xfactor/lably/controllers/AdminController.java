package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

    @GetMapping("/hello")    
    public String hello() {
        return "Hello from AdminController";
    }


    @GetMapping("/")    
    public String hello_world() {
        return "Hello World";
    }

    @GetMapping("/greet/{text}/{text2}")
    public String greetings(@PathVariable String text, @PathVariable String text2) {
        return "Greetings from " + text + " " + text2;
    }
    

    @GetMapping("/greet2")
    public String greet2(@RequestParam String name, @RequestParam String age, @RequestParam String city) {
        return "Greetings from " + name + " " + age + " " + city;
    }

    @GetMapping("/greet3")
    public HashMap<String, String> greet3(@RequestParam String name, @RequestParam String age, @RequestParam String city) {
        HashMap<String, String> mymap = new HashMap<>();
        mymap.put("name", name);
        mymap.put("age", age);
        mymap.put("city", city);
        return mymap;
    }

    @GetMapping("/register")
    public Admin register(@RequestParam String name, @RequestParam String username,
    @RequestParam String password, @RequestParam String department) {
        // HashMap<String, String> mymap = new HashMap<>();
        // mymap.put("name", name);
        // mymap.put("username", username);
        // mymap.put("password", password);
        // mymap.put("department", department);
        // return mymap;

        Admin admin = new Admin();
        admin.setName(name);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setDepartment(department);
        return admin;
    }

    @PostMapping("/registerAdmin")
    public Admin registerPost(@RequestBody Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        // save admin to db
        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAllAdmins")
    public ArrayList<Admin> getAdmins() {
        return admins;
    }


    @GetMapping("findAdminByUserName")
    public Admin findAdmin(@RequestParam String username) {
        Admin admin1 = null;
        for (Admin admin : admins) {
            if(admin.getUsername().equalsIgnoreCase(username)) {
                admin1 = admin;
            }
        }
        return admin1;
    }
}
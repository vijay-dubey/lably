package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
// import java.util.UUID;
import java.util.List;

import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.repository.AdminRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

    @Autowired
    AdminRepository adminRepository;

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
        // admin.setId(UUID.randomUUID().toString());
        // save admin to db
        // admins.add(admin);
        Admin persistedAdmin = adminRepository.save(admin);
        return persistedAdmin;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAdmins() {
        List<Admin> persistedAdmins =  adminRepository.findAll();
        return persistedAdmins;
    }


    @GetMapping("getAdminByUsername")
    public Admin findAdmin(@RequestParam String username) {
        // Admin admin1 = null;
        // List<Admin> persistedAdmins =  adminRepository.findAll();
        // for (Admin admin : persistedAdmins) {
        //     if(admin.getUsername().equalsIgnoreCase(username)) {
        //         admin1 = admin;
        //     }
        // }
        // return admin1;


        Admin admin1 = adminRepository.findByUsername(username);
        return admin1;

        // Optional<Admin> admin = adminRepository.findById(id);
        // if(admin.isPresent()) {
        //     return admin.get();
        // }
        // return null;
    }

    @GetMapping("getAdminByDepartment")
    public List<Admin> getByDepartment(@RequestParam String department) {
        return adminRepository.retrieveByDepartment(department);
    }


    @GetMapping("deleteAdminById") 
    public void deleteAdminById(@RequestParam Long id) {
        adminRepository.deleteById(id);
    }

    @GetMapping("deleteAdminByUsername") 
    public void deleteAdminByUsername(@RequestParam String username) {
        Admin admin = adminRepository.findByUsername(username);
        adminRepository.delete(admin);
    }
}
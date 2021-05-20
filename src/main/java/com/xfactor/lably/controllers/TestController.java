package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.UUID;

import com.xfactor.lably.entity.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    ArrayList<Test> tests = new ArrayList<>();

    @PostMapping("/addTest")
    public Test addTest(@RequestBody Test test) {
        test.setId(UUID.randomUUID().toString());
        tests.add(test);
        return test;
    }

    @GetMapping("/getTests")
    public ArrayList<Test> getAllTests() {
        return tests;
    }

    @GetMapping("/getTestByName")
    public Test findTestByName(@RequestParam String name) {
        Test ans = null;
        for (Test test : tests) {
            if(test.getName().equalsIgnoreCase(name)) {
                ans = test;
            }
        }
        return ans;
    }

}
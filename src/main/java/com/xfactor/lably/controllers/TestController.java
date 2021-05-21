package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Test;
import com.xfactor.lably.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRepository testRepo;

    @PostMapping("/addTest")
    public Test addTest(@RequestBody Test test) {
        return testRepo.save(test);
    }

    @GetMapping("/getTests")
    public List<Test> getAllTests() {
        return testRepo.findAll();
    }

    @GetMapping("/getTestByName")
    public Test findTestByName(@RequestParam String name) {
        return testRepo.findByName(name);
    }

}
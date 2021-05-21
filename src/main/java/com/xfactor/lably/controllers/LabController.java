package com.xfactor.lably.controllers;

import java.util.List;

import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lab")
public class LabController {
    
    @Autowired
    LabRepository labRepo;

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {
        return labRepo.save(lab);
    }
    
    @GetMapping("/getLabs")
    public List<Lab> getAllLabs() {
        return labRepo.findAll();
    }

    @GetMapping("/getLabByName")
    public Lab findLab(@RequestParam String name) {
        return labRepo.findByName(name);
    }

}

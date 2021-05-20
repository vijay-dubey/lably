package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.UUID;

import com.xfactor.lably.entity.Lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lab")
public class LabController {
    
    ArrayList<Lab> labs = new ArrayList<>();

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {
        lab.setId(UUID.randomUUID().toString());
        labs.add(lab);
        return lab;
    }
    
    @GetMapping("/getLabs")
    public ArrayList<Lab> getAllLabs() {
        return labs;
    }

    @GetMapping("/getLabByName")
    public Lab findLab(@RequestParam String name) {
        Lab res = null;
        for (Lab lab : labs) {
            if(lab.getName().equalsIgnoreCase(name)) {
                res = lab;
            }
        }
        return res;
    }

}

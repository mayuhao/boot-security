package com.boot.security.server.controller;

import com.boot.security.server.annotation.LogAnnotation;

import com.boot.security.server.service.MultiTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/multitable")
public class MultiTableController {

    @Autowired
    private MultiTableService multiTableService;


    @PostMapping("/updatecount")
    public int updatecount() {
       multiTableService.changebcrubcount();
       return 1;
    }

    @PostMapping("/updatecount/{id}")
    public int updatecountById(@PathVariable Long id){
        multiTableService.changebcrudcountById(id);
        return 1;
    }

}

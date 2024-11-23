package com.tharun.reports_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tharun.reports_app.service.CitizenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReportController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/")
    public String uiPage(){
        return "ui";
    }

}

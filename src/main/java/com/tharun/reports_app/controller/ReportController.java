package com.tharun.reports_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.service.CitizenService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReportController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/")
    public String indexPage(Model model){

        RequestDto req = new RequestDto();

        model.addAttribute("search", req);
        model.addAttribute("names", citizenService.getPlanNames());
        model.addAttribute("status", citizenService.getPlanStatuses());

        return "index";
    }

}

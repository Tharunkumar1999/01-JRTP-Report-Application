package com.tharun.reports_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.service.CitizenService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReportController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping("/search")
    public String handlerSearch(RequestDto requestDto, Model model){

        System.out.println(requestDto);

        List<CitizenPlan> plans = citizenService.search(requestDto);

        model.addAttribute("plans", plans);

        init(model);

        return "index";
    }


    @GetMapping("/")
    public String indexPage(Model model){
        init(model);
        return "index";
    }

    private void init(Model model) {
        RequestDto req = new RequestDto();

        model.addAttribute("search", req);
        model.addAttribute("names", citizenService.getPlanNames());
        model.addAttribute("status", citizenService.getPlanStatuses());
    }

}

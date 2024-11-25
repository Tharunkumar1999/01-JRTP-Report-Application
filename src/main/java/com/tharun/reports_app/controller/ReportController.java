package com.tharun.reports_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.service.CitizenService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ReportController {

    @Autowired
    private CitizenService citizenService;

    //To downlad data as Excel
    @GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws Exception{

        response.setContentType("application/octet-stream");
        response.addHeader("content-Disposition", "attachmen;filename=plans.xlsx");
        citizenService.exportExcel(response);
    }

    //To downlad data as PDF
    @GetMapping("/pdf")
    public void pdfExcel(HttpServletResponse response) throws Exception{

        response.setContentType("application/pdf");
        response.addHeader("content-Disposition", "attachmen;filename=plans.pdf");
        citizenService.exportPdf(response);
    }


    @PostMapping("/search")
    public String handlerSearch(@ModelAttribute("search") RequestDto requestDto, Model model){

        System.out.println(requestDto);

        List<CitizenPlan> plans = citizenService.search(requestDto);

        model.addAttribute("plans", plans);

        init(model);

        return "index";
    }


    @GetMapping("/")
    public String indexPage(Model model){
        RequestDto req = new RequestDto();
        model.addAttribute("search", req);
        init(model);
        return "index";
    }

    private void init(Model model) {
        model.addAttribute("names", citizenService.getPlanNames());
        model.addAttribute("status", citizenService.getPlanStatuses());
    }

}

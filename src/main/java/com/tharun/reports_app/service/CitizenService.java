package com.tharun.reports_app.service;

import java.util.List;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService {

    public List<String> getPlanNames();

    public List<String> getPlanStatuses();

    public List<CitizenPlan> search(RequestDto requestDto);

    //To downlad data as Excel
    public boolean exportExcel(HttpServletResponse response) throws Exception;

    public boolean exportPdf(HttpServletResponse response);

}

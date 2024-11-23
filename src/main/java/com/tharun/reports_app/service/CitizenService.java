package com.tharun.reports_app.service;

import java.util.List;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;

public interface CitizenService {

    public List<String> getPlanNames();

    public List<String> getPlanStatuses();

    public List<CitizenPlan> search(RequestDto requestDto);

    public boolean exportExcel();

    public boolean exportPdf();

}

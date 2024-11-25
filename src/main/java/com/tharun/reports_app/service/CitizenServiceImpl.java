package com.tharun.reports_app.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.tharun.reports_app.utility.*;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.repo.CitizenPlanRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

    @Autowired
    private exportPdf pdf;

    @Autowired
    private exportExcel excel;

    @Override
    public List<String> getPlanNames() {
        return citizenPlanRepository.getPlanName();
    }

    @Override
    public List<String> getPlanStatuses() {
        return citizenPlanRepository.getPlanStatus();
    }

    @Override
    public List<CitizenPlan> search(RequestDto requestDto) {

        CitizenPlan entity =new CitizenPlan();

        if(null != requestDto.getPlanName() && !"".equals(requestDto.getPlanName())){
            entity.setPlanName(requestDto.getPlanName());
        }
        if(null != requestDto.getPlanStatus() && !"".equals(requestDto.getPlanStatus())){
            entity.setPlanStatus(requestDto.getPlanStatus());
        }
        if(null != requestDto.getGender() && !"".equals(requestDto.getGender())){
            entity.setGender(requestDto.getGender());
        }
        return citizenPlanRepository.findAll(Example.of(entity));
    }

    //To downlad data as Excel
    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception {
        List<CitizenPlan> records=citizenPlanRepository.findAll();
        excel.generator(response, records);
        
        return true;
    }

    // Implentation to download data as PDF
    @Override  
    public boolean exportPdf(HttpServletResponse response) throws Exception{
       List<CitizenPlan> plan= citizenPlanRepository.findAll();
       pdf.generator(response, plan);
       return true;
    }

}
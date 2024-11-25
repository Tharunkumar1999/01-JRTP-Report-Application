package com.tharun.reports_app.service;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.io.File;
import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.repo.CitizenPlanRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

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

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception {

        // Workbook workbook = new XSSFWorkbook();
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("plans-data");

        Row headRow = sheet.createRow(0);

        headRow.createCell(0).setCellValue("Id");
        headRow.createCell(1).setCellValue("Citizen Name");
        headRow.createCell(2).setCellValue("Plan Name");
        headRow.createCell(3).setCellValue("Plan Status");
        headRow.createCell(4).setCellValue("Plan Start Date");
        headRow.createCell(5).setCellValue("Plan End Date");
        headRow.createCell(6).setCellValue("Benificary Amount");

        List<CitizenPlan>  records= citizenPlanRepository.findAll();

        int dataRowIndex=1;

        for(CitizenPlan plan:records){
            Row dataRow =sheet.createRow(1);
            dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(3).setCellValue(plan.getPlanStatus());
            dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
            dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
            dataRow.createCell(6).setCellValue(plan.getBenifitAmt());

            dataRowIndex++;
        }
        
        ServletOutputStream sos=response.getOutputStream();
        //FileOutputStream fos=new FileOutputStream(new File("plan.xls"));
        workbook.write(sos);
        workbook.close();

        return false;
    }

    @Override
    public boolean exportPdf() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportPdf'");
    }

}

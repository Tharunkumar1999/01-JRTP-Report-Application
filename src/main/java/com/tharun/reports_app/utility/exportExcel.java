package com.tharun.reports_app.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tharun.reports_app.entity.CitizenPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class exportExcel {


    public void generator(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception{
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
        
        FileOutputStream fos=new FileOutputStream(file);
        fos.close();

        ServletOutputStream sos=response.getOutputStream();
        workbook.write(sos);
        workbook.close();
    }
    
}

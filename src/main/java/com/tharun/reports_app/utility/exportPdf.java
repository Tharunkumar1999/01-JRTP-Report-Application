package com.tharun.reports_app.utility;

import java.util.List;


import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tharun.reports_app.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public class exportPdf  {


    public void generator(HttpServletResponse response, List<CitizenPlan> plans) throws Exception{
    Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Paragraph p =new Paragraph("Citizen Insurance Info");
        document.add(p);

        PdfPTable table = new PdfPTable(6);

        table.addCell("Id");
        table.addCell("Citiozen Name");
        table.addCell("Plan Name");
        table.addCell("Plan Status");
        table.addCell("Plan Start Date");
        table.addCell("Plan End Date");
        table.addCell("Benifit Amount");


       for(CitizenPlan plan : plans){
        table.addCell(String.valueOf(plan.getCitizenId()));
        table.addCell(String.valueOf(plan.getCitizenName()));
        table.addCell(String.valueOf(plan.getPlanName()));
        table.addCell(String.valueOf(plan.getPlanStatus()));
        table.addCell(String.valueOf(plan.getPlanStartDate()));
        table.addCell(String.valueOf(plan.getPlanEndDate()));
        table.addCell(String.valueOf(plan.getBenifitAmt()));
       }

        document.add(table);
        document.close();

    }
}





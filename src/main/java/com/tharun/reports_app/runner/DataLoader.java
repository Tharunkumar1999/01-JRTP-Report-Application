package com.tharun.reports_app.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner  {

    @Autowired
    CitizenPlanRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        repo.deleteAll();
        
        //cash plan data
        CitizenPlan c1=new CitizenPlan();
        c1.setCitizenName("Tharun");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenifitAmt(5000.00);

        
        CitizenPlan c2=new CitizenPlan();
        c2.setCitizenName("Kumar");
        c2.setGender("Male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Getting Rent amount");

        CitizenPlan c3=new CitizenPlan();
        c3.setCitizenName("Nancy");
        c3.setGender("Fe-Male");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setPlanStartDate(LocalDate.now().minusMonths(4));
        c3.setPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setBenifitAmt(75000.78);
        c3.setTerminatedDate(LocalDate.now());
        c3.setTerminationRsn("Employed now");

        //Food Plan data
        CitizenPlan c4=new CitizenPlan();
        c4.setCitizenName("Ramya");
        c4.setGender("Fe-Male");
        c4.setPlanName("Food");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now());
        c4.setPlanEndDate(LocalDate.now().plusMonths(6));
        c4.setBenifitAmt(67000.60);

        
        CitizenPlan c5=new CitizenPlan();
        c5.setCitizenName("Dhaya");
        c5.setGender("Male");
        c5.setPlanName("Food");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("Salaried Person");

        CitizenPlan c6=new CitizenPlan();
        c6.setCitizenName("Riya");
        c6.setGender("Fe-Male");
        c6.setPlanName("Food");
        c6.setPlanStatus("Terminated");
        c6.setPlanStartDate(LocalDate.now().minusMonths(4));
        c6.setPlanEndDate(LocalDate.now().plusMonths(6));
        c6.setBenifitAmt(23000.00);
        c6.setTerminatedDate(LocalDate.now());
        c6.setTerminationRsn("Employed now");

        //Medical Plan Data
        CitizenPlan c7=new CitizenPlan();
        c7.setCitizenName("Lavanya");
        c7.setGender("Fe-Male");
        c7.setPlanName("Medical");
        c7.setPlanStatus("Approved");
        c7.setPlanStartDate(LocalDate.now());
        c7.setPlanEndDate(LocalDate.now().plusMonths(6));
        c7.setBenifitAmt(9000.00);

        
        CitizenPlan c8=new CitizenPlan();
        c8.setCitizenName("Rahul");
        c8.setGender("Male");
        c8.setPlanName("Medical");
        c8.setPlanStatus("Denied");
        c8.setDenialReason("Rich person");

        CitizenPlan c9=new CitizenPlan();
        c9.setCitizenName("Tamya");
        c9.setGender("Fe-Male");
        c9.setPlanName("Medical");
        c9.setPlanStatus("Terminated");
        c9.setPlanStartDate(LocalDate.now().minusMonths(4));
        c9.setPlanEndDate(LocalDate.now().plusMonths(6));
        c9.setBenifitAmt(65000.00);
        c9.setTerminatedDate(LocalDate.now());
        c9.setTerminationRsn("Govt Job");

        //Education plan data
        CitizenPlan c10=new CitizenPlan();
        c10.setCitizenName("Jeeva");
        c10.setGender("Fe-Male");
        c10.setPlanName("Education");
        c10.setPlanStatus("Approved");
        c10.setPlanStartDate(LocalDate.now());
        c10.setPlanEndDate(LocalDate.now().plusMonths(6));
        c10.setBenifitAmt(4000.00);

        
        CitizenPlan c11=new CitizenPlan();
        c11.setCitizenName("Reshva");
        c11.setGender("Male");
        c11.setPlanName("Education");
        c11.setPlanStatus("Denied");
        c11.setDenialReason("Getting Rent amount");

        CitizenPlan c12=new CitizenPlan();
        c12.setCitizenName("Lily");
        c12.setGender("Fe-Male");
        c12.setPlanName("Education");
        c12.setPlanStatus("Terminated");
        c12.setPlanStartDate(LocalDate.now().minusMonths(4));
        c12.setPlanEndDate(LocalDate.now().plusMonths(6));
        c12.setBenifitAmt(58000.00);
        c12.setTerminatedDate(LocalDate.now());
        c12.setTerminationRsn("Employed now");


            List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);

            repo.saveAll(list);



    }

}

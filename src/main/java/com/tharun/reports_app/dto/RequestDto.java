package com.tharun.reports_app.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class RequestDto {

    private String planName;
    private String planStatus;
    private String gender;
    private LocalDate planStartDate;
    private LocalDate planEndDate;

}

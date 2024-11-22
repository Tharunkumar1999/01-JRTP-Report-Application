package com.tharun.reports_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.reports_app.dto.RequestDto;
import com.tharun.reports_app.entity.CitizenPlan;
import com.tharun.reports_app.repo.CitizenPlanRepository;

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
        return citizenPlanRepository.findAll();
    }

    @Override
    public boolean exportExcel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportExcel'");
    }

    @Override
    public boolean exportPdf() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportPdf'");
    }

}

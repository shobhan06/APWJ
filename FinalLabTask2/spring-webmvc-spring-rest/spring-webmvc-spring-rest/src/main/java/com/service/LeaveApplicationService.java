package com.service;

import com.domain.LeaveApplication;
import com.domain.Student;
import com.repository.LeaveApplicationRepository;
import com.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class LeaveApplicationService {

    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) {

        if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {

            leaveApplication.setFromDate(leaveApplication.getFromDate());
            leaveApplication.setToDate(leaveApplication.getToDate());
            leaveApplication.setTotalDays(leaveApplication.getTotalDays());
            leaveApplication.setReason(leaveApplication.getReason());
            leaveApplication.setLeaveType(leaveApplication.getLeaveType());
            leaveApplication.setStudent(leaveApplication.getStudent());
            return leaveApplicationRepository.create(leaveApplication);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public LeaveApplication get(Long id) {
        return leaveApplicationRepository.get(id);
    }
}

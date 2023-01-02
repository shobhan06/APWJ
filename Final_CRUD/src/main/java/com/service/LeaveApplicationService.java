package com.service;

import com.domain.LeaveApplication;
import com.repository.LeaveApplicationRepository;
//import com.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaveApplicationService {

    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) {

       /* if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {*/
            return leaveApplicationRepository.create(leaveApplication);
        /*}
        return false;*/
    }
    @Transactional
    public boolean update(LeaveApplication leaveApplication, Long id) {

        /* if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {*/
        return leaveApplicationRepository.update(leaveApplication,id);
        /*}
        return false;*/
    }

    @Transactional(readOnly = true)
    public LeaveApplication get(Long id) {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication= leaveApplicationRepository.get(id);
        return leaveApplication;
    }

    //@Transactional(readOnly = true)
    public  List<com.domain.LeaveApplication> getALL() {
        return  leaveApplicationRepository.getALL();
    }
    public boolean delete(Long id) {
        LeaveApplication leaveApplication = new LeaveApplication();
         leaveApplicationRepository.delete(id);
        return true;
    }
}

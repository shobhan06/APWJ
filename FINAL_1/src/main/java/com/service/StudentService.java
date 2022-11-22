package com.service;

import com.domain.leaveApplication;
import com.domain.leaveType;
import com.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void insert( ) throws SQLException {
        leaveApplication lapplication = new leaveApplication();
        leaveType obj = new leaveType();



        obj.setCategory("ABC");
        obj.setTotalDays(12);
        obj.setl_id(2);

        lapplication.setId(1);
        lapplication.setFromDate("12/12/2022");
        lapplication.setReason("fever");
        lapplication.setTotalDate(12);
        lapplication.setToDate("20/12/2022");
        lapplication.setLeaveT(obj);

        studentRepository.create(lapplication);





    }
}
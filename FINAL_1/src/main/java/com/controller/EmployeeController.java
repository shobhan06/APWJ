package com.controller;

import com.domain.Employee;
import com.domain.Student;
import com.domain.leaveApplication;
import com.domain.leaveType;
import com.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private StudentService studentService;

    public EmployeeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

 /*   @RequestMapping("/show")
    public String show(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "registration";
    }*/

    @RequestMapping("/submit")
    public String submit() throws SQLException {

            studentService.insert();
            return "confirmation";

    }
}

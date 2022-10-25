package com.controller;

import com.domain.Department;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.io.IOException;
import javax.sql.DataSource;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DataSource dataSource;

    public DepartmentController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<Department> departments = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("select * from departments");


        while(resultSet.next()) {


           Department department = new Department();

            department.setId(resultSet.getLong(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
            model.addAttribute("departments", departments);


        }
       return "department/list";

    }

    @RequestMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @RequestMapping("/create")
    public String create(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "department/create";
        }
        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("insert into departments (name,created_on) values (?,?)");
        statement.setString(1, department.getName());
        statement.setDate(2, Date.valueOf(LocalDate.now()));
        statement.execute();
        return "redirect:/departments/list";
    }
}

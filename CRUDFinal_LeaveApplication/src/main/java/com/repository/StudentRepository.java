/*
package com.repository;

import com.domain.LeaveApplication;
import com.domain.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<LeaveApplication> list() {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveApplication> studentQuery = session.createQuery("from LeaveApplication", LeaveApplication.class);
        return studentQuery.getResultList();
    }

    public boolean create(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return true;
    }

    public LeaveApplication get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LeaveApplication.class, id);
    }

    public  update(LeaveApplication student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }

    private List<Student> mapper(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();
        while(resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getLong(1));
            student.setFirstname(resultSet.getString(2));
            student.setLastname(resultSet.getString(3));
            students.add(student);
        }
        return students;
    }
}
*/

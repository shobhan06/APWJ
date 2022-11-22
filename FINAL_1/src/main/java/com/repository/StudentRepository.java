package com.repository;

import com.domain.Student;
import com.domain.leaveApplication;
import com.domain.leaveType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentRepository {

    private SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> studentQuery = session.createQuery("from Student", Student.class);
        return studentQuery.getResultList();
    }

    public boolean create(leaveApplication student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return true;
    }


    public Student get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    /*public boolean update(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, student.getFirstname());
        preparedStatement.setString(2, student.getLastname());
        preparedStatement.setLong(3, student.getId());
        return preparedStatement.execute();
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
    }*/
}

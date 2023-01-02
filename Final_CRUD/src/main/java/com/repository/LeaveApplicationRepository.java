package com.repository;

import com.domain.LeaveApplication;
import com.domain.LeaveType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeaveApplicationRepository {

    private SessionFactory sessionFactory;

    public LeaveApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<LeaveApplication> list() {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveApplication> leaveApplicationQuery = session.createQuery("from LeaveApplication", LeaveApplication.class);
        return leaveApplicationQuery.getResultList();
    }

    public boolean create(LeaveApplication leaveApplication) {
        Session session = sessionFactory.getCurrentSession();
        session.save(leaveApplication);
        return true;
    }

    public LeaveApplication get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LeaveApplication.class, id);
    }
    public List<LeaveApplication> getALL() {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveApplication> leaveTypeQuery = session.createQuery("from LeaveApplication", LeaveApplication.class);
        return leaveTypeQuery.getResultList();
    }
    public boolean  update(LeaveApplication leaveApplication, Long id)   {
        Session session = sessionFactory.getCurrentSession();
        LeaveApplication leaveApplication1 =session.get(LeaveApplication.class, id);
        leaveApplication1.setId(leaveApplication.getId());
        leaveApplication1.setFromDate(leaveApplication.getFromDate());
        leaveApplication1.setTotalDays(leaveApplication.getTotalDays());
        leaveApplication1.setToDate(leaveApplication.getToDate());
        leaveApplication1.setReason(leaveApplication.getReason());
        session.update(leaveApplication1);
        return  true;
    }

    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        LeaveApplication leaveApplication1 =session.get(LeaveApplication.class, id);
         session.delete(leaveApplication1);
         return true;
    }
}

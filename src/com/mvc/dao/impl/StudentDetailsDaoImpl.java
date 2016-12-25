package com.mvc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.bean.StudentDetails;
import com.mvc.dao.StudentDetailsDao;

@Repository("studentDetailsDao")
public class StudentDetailsDaoImpl implements StudentDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudentDetails(StudentDetails studentdetails) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(studentdetails);
	}

	@Override
	public StudentDetails getStudentDetails(int detailsid) {
		
		return (StudentDetails)sessionFactory.getCurrentSession().get(StudentDetails.class,detailsid );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentDetails> getStudentsDetails() {
		
		return (List<StudentDetails>)sessionFactory.getCurrentSession().createCriteria(StudentDetails.class).list();
	}

	@Override
	public void deleteStudentDetails(int detailsid) {
		Query delQuery = sessionFactory.getCurrentSession().createQuery("DELETE FROM StudentDetails WHERE detailsid = "+detailsid);
		int effectedRows = delQuery.executeUpdate();
		System.out.println("Deleted rows+"+effectedRows);
		System.out.println(detailsid+"  deleted");
		
	}
	
}

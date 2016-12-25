package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.bean.StudentDetails;
import com.mvc.dao.StudentDetailsDao;
import com.mvc.service.StudentDetailsService;




@Service("studentDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentDetailsServiceImpl implements StudentDetailsService {
	@Autowired
	private StudentDetailsDao studentDetailsDao;


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudentDetails(StudentDetails studentdetails) {
		studentDetailsDao.addStudentDetails(studentdetails);

	}

	@Override
	public StudentDetails getStudentDetails(int detailsid) {
		
		return  studentDetailsDao.getStudentDetails(detailsid);
	}

	@Override
	public List<StudentDetails> getStudentsDetails() {
		
		return studentDetailsDao.getStudentsDetails();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteStudentDetails(int detailsid) {
		studentDetailsDao.deleteStudentDetails(detailsid);

	}
}

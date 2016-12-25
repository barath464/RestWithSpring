package com.mvc.service;

import java.util.List;

import com.mvc.bean.StudentDetails;

public interface StudentDetailsService {
	
	public void addStudentDetails(StudentDetails studentdetails );

	public StudentDetails getStudentDetails(int detailsid);

	public List<StudentDetails> getStudentsDetails();

	public void deleteStudentDetails(int detailsid);

}

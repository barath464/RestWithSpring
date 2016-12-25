package com.mvc.dao;

import java.util.List;

import com.mvc.bean.StudentDetails;

public interface StudentDetailsDao {
	
	public void addStudentDetails(StudentDetails studentdetails );

	public StudentDetails getStudentDetails(int detailsid);

	public List<StudentDetails> getStudentsDetails();

	public void deleteStudentDetails(int detailsid);

}

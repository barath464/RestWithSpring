package com.mvc.dao;

import java.util.List;

import com.mvc.bean.Student;

public interface StudentDao {
	public void addStudent(Student student);

	public Student getStudent(int sid);

	public List<Student> getStudents();

	public void deleteStudent(int sid);

}

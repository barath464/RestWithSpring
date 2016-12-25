package com.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.bean.Student;
import com.mvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public @ResponseBody Student getStudentInJSON(@PathVariable int id) {
		System.out.println(id);
		Student student = studentService.getStudent(id);
		return student;
	}

	@RequestMapping(value = "/getallstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> getallStudentInJSON() {
		List<Student> students = new ArrayList<Student>();
		students = studentService.getStudents();
		return students;
	}

}

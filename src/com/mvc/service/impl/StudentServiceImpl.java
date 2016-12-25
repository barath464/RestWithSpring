package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.bean.Student;
import com.mvc.dao.StudentDao;
import com.mvc.service.StudentService;
	
@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

	public class StudentServiceImpl implements StudentService {

	  	@Autowired
		private StudentDao studentDao;
		

		@Override
		@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		
		public void addStudent(Student student) {
			studentDao.addStudent(student);
		}

		@Override
		public Student getStudent(int sid) {
			
			return studentDao.getStudent(sid);
		}

		@Override
		public List<Student> getStudents() {
		
			return studentDao.getStudents();
		}

		@Override
		public void deleteStudent(int sid) {
			studentDao.deleteStudent(sid);
			
		}

	}



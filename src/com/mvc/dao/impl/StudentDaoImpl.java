package com.mvc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.bean.Student;
import com.mvc.dao.StudentDao;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
		
	}

	@Override
	public Student getStudent(int sid) {
		Student student =(Student)sessionFactory.getCurrentSession().get(Student.class, sid);
		System.out.println(student);
		return student;	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {
		
		return (List<Student>)sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}

	@Override
	public void deleteStudent(int sid) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Student WHERE sid = "+sid).executeUpdate();
		System.out.println("deleted "+sid);
	}


}

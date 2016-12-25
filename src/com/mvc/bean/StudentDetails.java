package com.mvc.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="stud_details")
@Component
public class StudentDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	//@GeneratedValue
	@Column(name="details_id")
	private int detailsid;
	@Column(name="s_age")
	private int age;
	@Column(name="s_details")
	private String details;
	@OneToOne
	@JoinColumn(name="s_id")
	private Student student;
	/**
	 * 
	 */
	public StudentDetails() {
	}
	public int getDetailsid() {
		return detailsid;
	}
	public void setDetailsid(int detailsid) {
		this.detailsid = detailsid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StudentDetails [detailsid=" + detailsid + ", age=" + age + ", details=" + details + ", student="
				+ student + "]";
	}
	/**
	 * @param detailsid
	 * @param age
	 * @param details
	 * @param student
	 */
	public StudentDetails(int detailsid, int age, String details, Student student) {
		this.detailsid = detailsid;
		this.age = age;
		this.details = details;
		this.student = student;
	}
	
}

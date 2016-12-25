package com.mvc.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="Stud")
public class Student implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String toString() {
		return "Student [id=" + sid + ", name=" + name + "]";
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="s_id")
	@NotEmpty(message="Id  should not be empty")
	private int sid;
	@Column(name="s_name")
	@NotEmpty(message="Name should not  be empty")
	private String name;
	
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	public Student() {
	}
	/**
	 * @param id
	 * @param name
	 */
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
	}
	
}

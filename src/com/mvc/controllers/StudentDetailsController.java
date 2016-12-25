package com.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.bean.StudentDetails;
import com.mvc.service.StudentDetailsService;
import com.mvc.service.StudentService;

@Controller
public class StudentDetailsController {
	
	@Autowired
	private StudentDetailsService studentDetailsService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value= "/insertdetails" ,method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("command") StudentDetails studentDetails, BindingResult result){
        studentDetailsService.addStudentDetails(studentDetails);
		return new ModelAndView("redirect:/savedetails");
	}
	
	@RequestMapping(value= "/savedetails" ,method = RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute("command") StudentDetails studentDetails, BindingResult result){
		Map<String,Object> allstudentsdetails = new HashMap<String,Object>();
		allstudentsdetails.put("studentsdetails", studentDetailsService.getStudentsDetails());
	   	allstudentsdetails.put("students", studentService.getStudents());
		return new ModelAndView("studentdetailsview",allstudentsdetails);
	}
	
	@RequestMapping(value= "/deletedetails" ,method = RequestMethod.GET)
	public ModelAndView deleted(@ModelAttribute("command") StudentDetails studentDetails, BindingResult result){
        studentDetailsService.deleteStudentDetails(studentDetails.getDetailsid());
		Map<String,Object> allstudentsdetails = new HashMap<String,Object>();
		allstudentsdetails.put("studentsdetails", studentDetailsService.getStudentsDetails());
		allstudentsdetails.put("students", studentService.getStudents());
		return new ModelAndView("studentdetailsview",allstudentsdetails);
	}

	@RequestMapping(value= "/editdetails" ,method = RequestMethod.GET)
	public ModelAndView edited(@ModelAttribute("command") StudentDetails studentDetails, BindingResult result){
		Map<String,Object> allstudentsdetails = new HashMap<String,Object>();
		allstudentsdetails.put("studetails", studentDetailsService.getStudentDetails(studentDetails.getDetailsid()));
		allstudentsdetails.put("studentsdetails", studentDetailsService.getStudentsDetails());
		allstudentsdetails.put("students", studentService.getStudents());
		return new ModelAndView("studentdetailsview",allstudentsdetails);
	}

}

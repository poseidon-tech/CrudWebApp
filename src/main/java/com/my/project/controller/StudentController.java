package com.my.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.project.model.Student;
import com.my.project.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentservice;
	//display list of services
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("studentlist",studentservice.getAllStudents());
		return "index";
	}
	@GetMapping("/newStudentForm")
	public String addStudent(Model model)
	{
		Student s=new Student();
		model.addAttribute("student",s);
		return "new_student";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student s)
	{
		studentservice.saveStudent(s);
		return "redirect:/";
	}
	
	@GetMapping("/showUpdateform/{id}")
	public String showUpdateform(@PathVariable("id") int id,Model model)
	
	{
	   Student st=studentservice.getStudentById(id);
	   model.addAttribute("student",st);
	   return "update_student";
	}
	@GetMapping("/showDeleteform/{id}")
	public String showDeleteform(@PathVariable("id") int id,Model model)
	
	{
	  studentservice.delStudentById(id);
	  
	   return "redirect:/";

}
}

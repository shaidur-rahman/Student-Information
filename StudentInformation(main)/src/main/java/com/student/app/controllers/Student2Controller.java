package com.student.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.student.app.model.Student2;
import com.student.app.service.Student2Service;

@Controller
public class Student2Controller {

	@Autowired
	Student2Service student2Service;

	@RequestMapping("/addStudent")
	public String getAddStudent(Model model) {
		model.addAttribute("student2", new Student2());
		System.out.println("\n\n" + student2Service.findStudents() + "\n\n");
		return "addStudent";
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public String postAddStudent(Model model, Student2 student2) {
		System.out.println("\n\n" + student2 + "\n\n");
		student2Service.saveNewStudent(student2);
		model.addAttribute("success", "New Student Created");
		return "addStudent";
	}

	@RequestMapping("/allStudent")
	public String showAllStudent(Model model) {
		model.addAttribute("student", student2Service.findStudents());
		return "allStudent";
	}
}

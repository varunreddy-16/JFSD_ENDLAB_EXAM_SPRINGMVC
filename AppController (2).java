package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@Autowired
	DAO dao;
	
	@GetMapping("/show")
	//@ResponseBody
	public String show (Model m) {
		List<Student> l = dao.getAllStudents();
		m.addAttribute("list", l);
		return "show.jsp";
	}
	
	@GetMapping("/add")
	public String add (Model m) {
		m.addAttribute("command", new Student());
		return "add.jsp";
	}
	
	@PostMapping("/addsave")
	public String addsave (@ModelAttribute("s") Student s) {
		int r = dao.insert(s);
		return "redirect:/add";
	}
	
}

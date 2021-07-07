package com.sun.controller;

import com.sun.entity.Student;
import com.sun.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/mapper")
public class StudentHandler {

	@Autowired
	private StudentMapper studentMapper;

	@GetMapping("/findAll")
	public String findAll(Model model) {
		model.addAttribute("list", studentMapper.findAll());
		return "index";
	}

	@GetMapping("/findById/{id}")
	public ModelAndView findById(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", studentMapper.findById(id));
		modelAndView.setViewName("update");
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		studentMapper.delete(id);
		return "redirect:/mapper/findAll";
	}

	@PostMapping("/update")
	public String update(Student student) {
		studentMapper.update(student);
		return "redirect:/mapper/findAll";
	}

	@PostMapping("/save")
	public String save(Student student) {
		studentMapper.save(student);
		return "redirect:/mapper/findAll";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "add";
	}

}

package com.sd.demo.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.demo.entity.Editorial;
import com.sd.demo.reposository.EditorialRepository;

@Controller
public class EditorialController {
	@Autowired
	EditorialRepository editRep;
	
	@RequestMapping("/insertarEditorial")
	public String insertarEditorial(Editorial editorial, Model model) {
		editRep.save(editorial);
		return "insertarEditorial";
	}
	@RequestMapping("/editorial")
	public String editorial(Model model) {
		model.addAttribute("editoriales",editRep.findAll());
		return "editorial";
	}
	@RequestMapping("/nuevaEditorial")
	public String nuevaEditorial() {
		return "nuevaEditorial";
	}

}

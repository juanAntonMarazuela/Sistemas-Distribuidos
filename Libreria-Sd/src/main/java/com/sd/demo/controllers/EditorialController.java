package com.sd.demo.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.demo.entity.Editorial;
import com.sd.demo.reposository.EditorialRepository;

@Controller
public class EditorialController {
	@Autowired
	EditorialRepository editRep;
	
	@PostConstruct
	public void init() {
		editRep.save(new Editorial("Bruño",6123456,"brunoeditorial@gmail.com","Plaza de España","14785"));
		editRep.save(new Editorial("Santillana",7215216,"santillanaeditorial@gmail.com","Principe pio","25789"));
	}
	@RequestMapping("/editorial")
	public String editorial() {
		return "editorial";
	}
}

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
	
	@PostConstruct
	public void init() {
		editRep.save(new Editorial("Editorial Sudamericana",612345623,"esudamericana@gmail.com","Plaza Bolívar","14785"));
		editRep.save(new Editorial("DeBolsillo",721521632,"debolsillo@gmail.com","Principe pio","25789"));
		editRep.save(new Editorial("Booket",612983512,"booket@gmail.com","Callao","71273"));
		editRep.save(new Editorial("Planeta",632839182,"planeta@gmail.com","Castellana","71829"));
	}
	@RequestMapping("/editorial")
	public String editorial(Model model) {
		model.addAttribute("editoriales",editRep.findAll());
		return "editorial";
	}
}

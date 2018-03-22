package com.sd.demo.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.EditorialRepository;
import com.sd.demo.reposository.LibroRepository;

@Controller
public class CatalogoController {
	@Autowired
	private LibroRepository libRep;
	@Autowired
	private EditorialRepository editRep;
	
	@PostConstruct
	public void init() {
		Editorial e1 = editRep.findByNombre("Bruño");
		Editorial e2 = editRep.findByNombre("Santillana");
		
		libRep.save(new Libro("Juan","Sistemas",e1,1982,200,"84-7735-786-2",19.98,"Educacion"));
		libRep.save(new Libro("Diego","Distribuidos",e2,1970,120,"90-2564-852-1",30.54,"Misterio"));
	}
	
	@RequestMapping("/")
	 public String tablon(Model model) {	
		return "index";
	}
	@RequestMapping("/catalogo")
	public String catalogo(Model model) {		
		model.addAttribute("libros",libRep.findAll());
		return "catalogo";
	}



}

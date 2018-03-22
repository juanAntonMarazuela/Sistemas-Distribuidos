package com.sd.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.LibroRepository;

@Controller
public class InsertarController {
	
	@Autowired
	private LibroRepository libRep;
	
	@RequestMapping("/insertar")
	public String insertar(Libro libro,Model model) {
		libRep.save(libro);
		return "insertar";
	}

}
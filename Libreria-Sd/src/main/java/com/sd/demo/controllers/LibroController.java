package com.sd.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.EditorialRepository;
import com.sd.demo.reposository.LibroRepository;

@Controller
public class LibroController {
	@Autowired
	LibroRepository libRep;
	@Autowired
	EditorialRepository editRep;
	
	@RequestMapping("/libro/{id}")
	public String libro(Model model,@PathVariable Long id){
		Libro lib = libRep.getOne(id);
		
		model.addAttribute("libro",lib);
		
		return "libro";
	}
	@RequestMapping("/nuevoLibro")
	public String nuevoLibro(Model model) {
		List<Editorial> editoriales = editRep.findAll();
		model.addAttribute("editoriales", editoriales);
		return("nuevoLibro");

	}
}

package com.sd.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.EditorialRepository;
import com.sd.demo.reposository.LibroRepository;

@Controller
public class InsertarController {
	
	@Autowired
	private LibroRepository libRep;
	@Autowired
	private EditorialRepository editRep;
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam String edit,Libro libro, Model model) {
		
		Editorial e = editRep.findByNombre(edit);
		libro.setEditorial(e);
		libRep.save(libro);
		e.getLibros().add(libro);
		editRep.save(e);

		return "insertar";

	}

}
package com.sd.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.LibroRepository;

@Controller
public class MostrarLibroController {
	
	@Autowired
	private LibroRepository libRep;
	
	@RequestMapping("/mostrarlibro")
	public String mostrar(@RequestParam String titulo, @RequestParam String autor, Model model) {
		
		List<Libro> varioslibros = libRep.findByTituloAndAutor(titulo, autor);
		
		model.addAttribute("libros", varioslibros);
		return "libro";
	}

}

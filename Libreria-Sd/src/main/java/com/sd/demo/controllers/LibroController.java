package com.sd.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibroController {
	@RequestMapping("/libro")
	public String libros(){
		return "libro";
	}
	@RequestMapping("/nuevoLibro")
	public String nuevoLibro() {
		return "nuevoLibro";
	}
}

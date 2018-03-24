package com.sd.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.demo.entity.Editorial;
import com.sd.demo.reposository.EditorialRepository;


@Controller
public class MostrarEditorialController {
	
	@Autowired
	private EditorialRepository editRep;
	
	@RequestMapping("/mostrareditorial")
	public String mostrar(@RequestParam String nombre,@RequestParam String codigoif, Model model) {
		
		List<Editorial> variaseditoriales = editRep.findByNombreAndCodigoIF(nombre,codigoif);
		model.addAttribute("editoriales", variaseditoriales);
		return "editorialespecifica";
	}

}
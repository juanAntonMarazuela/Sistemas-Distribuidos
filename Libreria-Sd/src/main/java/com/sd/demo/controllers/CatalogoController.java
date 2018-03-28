package com.sd.demo.controllers;

import java.util.ArrayList;
import java.util.List;

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
		Editorial e1 = editRep.findByNombre("Editorial sudamericana");
		Editorial e2 = editRep.findByNombre("DeBolsillo");
		Editorial e3 = editRep.findByNombre("Booket");
		Editorial e4 = editRep.findByNombre("Planeta");
		
		libRep.save(new Libro("Gabriel García Marquez","Cien años de soledad",1967,481,"84-7735-786-2",23.65,"Novela",e1));
		libRep.save(new Libro("Anne Frank","El diario de Ana Frank",1947,217,"90-2564-852-1",30.54,"Juvenil",e2));
		libRep.save(new Libro("Paulo Coelho","El alquimista",1988,304,"72-2162-827-9",26.21,"Novela",e3));
		libRep.save(new Libro("Dan Brown","El código Da Vinci",2003,582,"67-9274-192-4",31.23,"Misterio",e4));
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

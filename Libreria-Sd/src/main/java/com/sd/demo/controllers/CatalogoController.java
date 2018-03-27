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
		
		libRep.save(new Libro("Gabriel García Marquez","Cien años de soledad",e1,1967,481,"84-7735-786-2",23.65,"Novela"));
		libRep.save(new Libro("Anne Frank","El diario de Ana Frank",e2,1947,217,"90-2564-852-1",30.54,"Juvenil"));
		libRep.save(new Libro("Paulo Coelho","El alquimista",e3,1988,304,"72-2162-827-9",26.21,"Novela"));
		libRep.save(new Libro("Dan Brown","El códiog Da Vinci",e4,2003,582,"67-9274-192-4",31.23,"Misterio"));
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

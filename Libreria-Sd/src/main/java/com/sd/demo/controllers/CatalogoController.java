package com.sd.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
public class CatalogoController {
	@Autowired
	private LibroRepository libRep;
	@Autowired
	private EditorialRepository editRep;
		
	@PostConstruct
	public void init() {
		

		
		Editorial e1 = editRep.save(new Editorial("Editorial Sudamericana",612345623,"esudamericana@gmail.com","Plaza Bolívar","14785"));
		Editorial e2 = editRep.save(new Editorial("DeBolsillo",721521632,"debolsillo@gmail.com","Principe pio","25789"));
		Editorial e3 = editRep.save(new Editorial("Booket",612983512,"booket@gmail.com","Callao","71273"));
		Editorial e4 = editRep.save(new Editorial("Planeta",632839182,"planeta@gmail.com","Castellana","71829"));
		
		
		Libro l1 = new Libro("Gabriel García Marquez","Cien años de soledad",1967,481,"84-7735-786-2",23.65,"Novela",e1);
		Libro l2 = new Libro("Anne Frank","El diario de Ana Frank",1947,217,"90-2564-852-1",30.54,"Juvenil",e2);
		Libro l3 = new Libro("Paulo Coelho","El alquimista",1988,304,"72-2162-827-9",26.21,"Novela",e3);
		Libro l4 = new Libro("Dan Brown","El código Da Vinci",2003,582,"67-9274-192-4",31.23,"Misterio",e4);
		
		e1.getLibros().add(l1);
		e2.getLibros().add(l2);
		e3.getLibros().add(l3);
		e4.getLibros().add(l4);
		
		editRep.save(e1);
		editRep.save(e2);
		editRep.save(e3);
		editRep.save(e4);
		
		libRep.save(l1);
		libRep.save(l2);
		libRep.save(l3);
		libRep.save(l4);
		
		
	}
	
	@RequestMapping("/")
	 public String tablon(Model model) {	
		return "index";
	}
	@RequestMapping("/catalogo")
	public String catalogo(Model model,  @RequestParam(defaultValue = "titulo") String sort, @RequestParam(defaultValue = "asc") String ord) {
		
		List<Libro> respLibros = new ArrayList<>();
		switch (sort) {
		case "autor":
			respLibros = ord.equals("asc") ? libRep.findAllByOrderByAutorAsc() : libRep.findAllByOrderByAutorDesc(); 
			break;
		case "editorial":
			respLibros = ord.equals("asc") ? libRep.findAllByOrderByEditorialAsc() : libRep.findAllByOrderByEditorialDesc();
			break;
		case "titulo":
			respLibros = ord.equals("asc") ? libRep.findAllByOrderByTituloAsc() : libRep.findAllByOrderByTituloDesc();
			break;
		}
		model.addAttribute("libros",respLibros);
		model.addAttribute("sorting", sort);
		model.addAttribute("order" , ord);
		return "catalogo";
	}



}

package com.sd.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogoController {
	
	@Autowired
	private LibroRepository repLibros;
	
	@RequestMapping("/")
	   public String tablon(Model model) {	
	      model.addAttribute("libros", repLibros.findAll());
	      return "index";
	   }


}

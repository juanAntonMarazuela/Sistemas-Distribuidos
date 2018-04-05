package com.sd.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/libro/editar/{id}")
	public String editarLibro (Libro libro, Model model, @PathVariable Long id, @RequestParam(name="send",required=false ) String enviar, @RequestParam(required=false) String edit) {
		
		
		Optional<Libro> libroAntiguoOp = libRep.findById(id.longValue());
		Libro libroAntiguo = libroAntiguoOp.get();
		
		boolean isEdition;
		
		isEdition = (enviar!=null);
		
		/* Se estan enviando los datos desde el formulario*/
		if (isEdition) {
			
			if (!libro.getTitulo().isEmpty())
				libroAntiguo.setTitulo(libro.getTitulo());
			
			if (!libro.getAutor().isEmpty())
				libroAntiguo.setAutor(libro.getAutor());
				
			if ((edit!=null && !edit.isEmpty())) {
				Editorial editorial = editRep.findByNombre(edit);
				if (!editorial.equals(libroAntiguo.getEditorial())) {
					editorial.getLibros().remove(libroAntiguo);
					editorial.getLibros().add(libroAntiguo);
					libroAntiguo.setEditorial(editRep.save(editorial));
				}
			}
				
			libroAntiguo.setAno(libro.getAno());
			libroAntiguo.setNumPaginas(libro.getNumPaginas());
			libroAntiguo.setIsbn(libro.getIsbn());
			libroAntiguo.setPrecio(libro.getPrecio());
			libroAntiguo.setCategoria(libro.getCategoria());
			
			libroAntiguo = libRep.save(libroAntiguo);
					
		}

		List<Editorial> editoriales = editRep.findAll();
		model.addAttribute("editoriales", editoriales);
		model.addAttribute("libro", libroAntiguo);
		model.addAttribute("hasBeenUpdated", isEdition);
		
		return "editarLibro";
	}
}

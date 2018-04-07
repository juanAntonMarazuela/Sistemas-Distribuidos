package com.sd.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.demo.entity.Editorial;
import com.sd.demo.entity.Libro;
import com.sd.demo.reposository.EditorialRepository;

@Controller
public class EditorialController {
	@Autowired
	EditorialRepository editRep;
	
	@RequestMapping("/insertarEditorial")
	public String insertarEditorial(Editorial editorial, Model model) {
		editRep.save(editorial);
		return "insertarEditorial";
	}
	@RequestMapping("/editorial")
	public String editorial(Model model) {
		model.addAttribute("editoriales",editRep.findAll());
		return "editorial";
	}
	@RequestMapping("/nuevaEditorial")
	public String nuevaEditorial() {
		return "nuevaEditorial";
	}
	
	@RequestMapping("/editorial/editar/{id}")
	public String editarLibro (Editorial editorial, Model model, @PathVariable Long id, @RequestParam(name="send",required=false ) String enviar) {
		
		
		Optional<Editorial> editorialAntiguaOp = editRep.findById(id.longValue());
		Editorial editorialAntigua = editorialAntiguaOp.get();
		
		boolean isEdition;
		
		isEdition = (enviar!=null);
		
		/* Se estan enviando los datos desde el formulario*/
		if (isEdition) {
			
			if (!editorial.getNombre().isEmpty())
				editorialAntigua.setNombre(editorial.getNombre());
			
			if (!editorial.getEmail().isEmpty())
				editorialAntigua.setEmail(editorial.getEmail());
			
			if (!editorial.getDireccionPostal().isEmpty())
				editorialAntigua.setDireccionPostal(editorial.getDireccionPostal());
			if (!editorial.getCodigoIF().isEmpty())
				editorialAntigua.setCodigoIF(editorial.getCodigoIF());
			
			editorialAntigua.setNumTelefono(editorial.getNumTelefono());
			
			editorialAntigua = editRep.save(editorialAntigua);
					
		}

		List<Editorial> editoriales = editRep.findAll();
		model.addAttribute("editoriales", editoriales);
		model.addAttribute("editorial", editorialAntigua);
		model.addAttribute("hasBeenUpdated", isEdition);
		
		return "editarEditorial";
	}

}

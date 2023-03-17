package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Responsable;
import com.inti.repository.IResponsableRepository;

@Controller
@RequestMapping("respo")
public class ResponsableControlleur {
	@Autowired
	IResponsableRepository irr;
	

	
	@GetMapping("ajout")
	public String ajoutRespo(Model m) {
		
		return "ajoutRespo";
	}
	
	@PostMapping("ajout")
	public String ajout(@ModelAttribute("responsable")Responsable respo) {
		irr.save(respo);
		return "ajoutRespo";
		
		
	}
	@GetMapping("liste")
	public String liste(Model m) {
		m.addAttribute("listRespo", irr.findAll().toArray());
		
		return "listeRespo";
		
	}
	
	@GetMapping("attribuer")
	public String attribuer(Model m,@RequestParam("id") int idRespo) {
		m.addAttribute("respo", irr.getById(idRespo));
		
		
		
		return "attribuer";
	}

}

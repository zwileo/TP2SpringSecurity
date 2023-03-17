package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Responsable;
import com.inti.repository.IResponsableRepository;

@Controller
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

}

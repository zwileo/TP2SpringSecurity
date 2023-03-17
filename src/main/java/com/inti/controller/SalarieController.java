package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Chambre;
import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@Controller
public class SalarieController {

	@Autowired
	ISalarieRepository isr;
	
	@GetMapping("createSalarie")
	public String createSalarieForm() {
		return "createSalarieForm";
	}
	
	@PostMapping("createSalarie")
	public String createSalarie(@ModelAttribute("salarie") Salarie s) {
		
		isr.save(s);
		
		return "redirect:/createSalarie";
	}
	
	@GetMapping("louerChambre")
	public String louerChambre(@ModelAttribute("chambre") Chambre c)
	{
		return "louerchambre";
	}
}

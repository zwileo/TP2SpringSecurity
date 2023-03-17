package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

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
	
	@GetMapping("listeSalarie")
	public String listeSalarie(Model m) {
		List<Salarie> listeSalarie = isr.findAll();
		m.addAttribute("listeSalarie",listeSalarie);
		return("listeSalarie");		
	}
	
	@GetMapping("deleteSalarie/{id}")
	public String deleteSalarie(@PathVariable int id) {
		isr.deleteById(id);
		return "redirect:/listeSalarie";
	}

	@GetMapping("updateSalarie/{id}")
	public String updateSalarieForm(@PathVariable int id, Model m) {
		m.addAttribute("salarie", isr.getReferenceById(id));
		
		return "updateSalarie";
	}

	@PostMapping("updateSalarie")
	public String updateSalarie(@ModelAttribute("sal") Salarie s) {
		
		isr.save(s);
		return "redirect:/listeSalarie";
	}
	
	@GetMapping("louerChambre")
	public String louerChambre(@ModelAttribute("chambre") Chambre c)
	{
		return "louerchambre";
	}
}

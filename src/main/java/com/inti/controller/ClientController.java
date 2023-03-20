package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.inti.model.Client;
import com.inti.repository.IClientRepository;

@Controller
@RequestMapping("client")
public class ClientController {
	@Autowired
	IClientRepository icr;
	
	@GetMapping("ajoutClient")
	public String ajoutClient() {
		return "formClient";
	}

	@PostMapping("saveClient")
	public String saveClient(@ModelAttribute("client") Client client) {
		icr.save(client);

		return "redirect:/ajoutClient";
	}
	@GetMapping("listeClient")
	public String listeClient(Model m) {

		m.addAttribute("listeClient", icr.findAll());

		return "listeClient";
	}

	@GetMapping("getClient")
	public String getClient(@RequestParam("id") int id, Model m) {
		Client c = icr.findById(id).get();

		m.addAttribute("client", c);

		return "afficherClient";
	}
	
	@GetMapping("delete/{id}")
	public String deleteClient(@PathVariable("id") int id) {
		icr.deleteById(id);

		return "redirect:/listeClient";
	}

	@GetMapping("update/{id}")
	public String ModifClient(@PathVariable("id") int id, Model m) {
		m.addAttribute("client", icr.getReferenceById(id));

		return "modifClient";
	}

	@PostMapping("modifClient")
	public String updateVoiture(@ModelAttribute("client") Client client) {

		icr.save(client);

		return "redirect:/listeClient";
	}
	
	

}

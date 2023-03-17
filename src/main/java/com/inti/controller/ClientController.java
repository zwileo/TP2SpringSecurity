package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Client;
import com.inti.repository.IClientRepository;

@Controller
public class ClientController {
	@Autowired
	IClientRepository icr;
	
	@GetMapping("ajoutClient")
	public String ajoutClient() {
		return "formClient";
	}

	@PostMapping("saveClient")
	public String saveVoiture(@ModelAttribute("client") Client client) {
		icr.save(client);

		return "redirect:/ajoutClient";
	}
	
	
	

}

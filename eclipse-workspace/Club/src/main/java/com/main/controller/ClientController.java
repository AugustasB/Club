package com.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.entities.Client;
import com.main.services.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping("/")
	public String clients(Model model) {
		model.addAttribute("clients", clientService.getClients());
		return "clients";
	}
	
	@GetMapping("/newClient")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "client_new";
	}
	
	@PostMapping("/newClient")
	public String saveClient(@Valid @ModelAttribute Client client, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "client_new";
		}
		clientService.addClient(client);
		return "redirect:/";
	}
	
	@GetMapping("/updateClient")
	public String showClient(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("client", clientService.getClientById(id));
		return "client_update";
	}
	
	@PostMapping("/updateClient")
	public String updateClient(@ModelAttribute Client client, Model model) {
		clientService.updateClient(client);
		return "redirect:/";
	}
	
	@GetMapping("/deleteClient")
	public String deleteClient(@RequestParam("id") Integer id) {
		clientService.deleteClient(id);
		return "redirect:/";
	}
}

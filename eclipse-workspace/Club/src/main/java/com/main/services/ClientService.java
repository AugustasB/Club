package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.entities.Client;
import com.main.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getClients() {
		return clientRepository.findAll();
	}
	
	public Client addClient(Client client) {
		client.setPassword((new BCryptPasswordEncoder()).encode(client.getPassword()));
		return clientRepository.save(client);
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client updateClient(Client client) {
		Client old = this.getClientById(client.getId());
		old.setName(client.getName());
		old.setEmail(client.getEmail());
		old.setSurname(client.getSurname());
		old.setPhone(client.getPhone());
		old.setPassword(client.getPassword());
		old.setUsername(client.getUsername());
		old.setRole(client.getRole());
		clientRepository.save(old);
		return old;
	}
	
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}
	
	public Client findByUsername(String username) {
		return clientRepository.findByUsername(username);
	}
	
	public Client findByEmail(String email) {
		return clientRepository.findByEmail(email);
	}

}

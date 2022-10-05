package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	UtenteRepository repo;
	
	public Utente register(Utente utente) {
		
		try {
			utente = repo.save(utente);
			return utente;
		} catch(Exception e) {
			e.getStackTrace();
			return null;
		}
		
	}
	
	public Utente login(String username, String password) {
		Utente utente = repo.login(username, password);
		return utente;
	}
	
	public Utente userById(long id) {
		return repo.findById(id).orElse(null);
	}
	
	public boolean edit(long id, String nome, String cognome, String oldPassword, String newPassword) {
		Utente utente = userById(id);
		
		if(utente != null && utente.getPassword().equals(oldPassword) && newPassword.isBlank()) {
			utente.setNome(nome);
			utente.setCognome(cognome);
			utente = repo.save(utente);
			return true;
		} else if(utente != null && utente.getPassword().equals(oldPassword) && !oldPassword.equals(newPassword) && newPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")) {
			utente.setNome(nome);
			utente.setCognome(cognome);
			utente.setPassword(newPassword);
			utente = repo.save(utente);
			return true;
		} else {
			return false;
		}
		
	}
	
}

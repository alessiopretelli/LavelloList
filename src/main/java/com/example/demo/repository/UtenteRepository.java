package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	@Query("select u from Utente u where u.username = :username and u.password = :password")
	public Utente login(String username, String password);
	
}

package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegistrazioneDTO {
	private String nome, cognome, username, password;

	public RegistrazioneDTO() {}
	
	public RegistrazioneDTO(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return nome != null && cognome != null && username != null && password != null && !nome.isBlank() && !cognome.isBlank() && nome.length() < 255 && cognome.length() < 255 && nome.matches("^[A-Za-z]+$") && cognome.matches("^[A-Za-z]+$") && username.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") && password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
	}
	
}

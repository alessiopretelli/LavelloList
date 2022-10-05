package com.example.demo.dto.request.utente;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EditUtenteDTO {
	private long idUtente;
	private String nome, cognome, oldPassword, newPassword;

	public EditUtenteDTO(long idUtente, String nome, String cognome, String oldPassword, String newPassword) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@JsonIgnore
	public boolean isValid() {
		return nome != null && cognome != null && oldPassword != null && !nome.isBlank() && !cognome.isBlank() && nome.length() < 255 && cognome.length() < 255 && nome.matches("^[A-Za-z]+$") && cognome.matches("^[A-Za-z]+$") && oldPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
	}
	
}

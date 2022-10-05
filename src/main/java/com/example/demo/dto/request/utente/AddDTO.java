package com.example.demo.dto.request.utente;

import java.time.LocalDate;

import com.example.demo.model.Utente;

public class AddDTO {
	private int priorita;
	private long idUtente;
	private LocalDate scadenza;
	private String nome, descrizione;
	
	public AddDTO() {}

	public AddDTO(int priorita, long idUtente, LocalDate scadenza, String nome, String descrizione) {
		super();
		this.priorita = priorita;
		this.idUtente = idUtente;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public AddDTO(int priorita, long idUtente, String nome, String descrizione) {
		super();
		this.priorita = priorita;
		this.idUtente = idUtente;
		this.scadenza = null;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public int getPriorita() {
		return priorita;
	}

	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setUtente(long idUtente) {
		this.idUtente = idUtente;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}

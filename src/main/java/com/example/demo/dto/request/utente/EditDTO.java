package com.example.demo.dto.request.utente;

import java.time.LocalDate;

import com.example.demo.model.Utente;

public class EditDTO {
	
	private long id;
	private int priorita;
	private boolean completato;
	private LocalDate scadenza;
	private String nome, descrizione;
	
	public EditDTO() {}
	
	public EditDTO(long id, int priorita, LocalDate scadenza, String nome, String descrizione) {
		super();
		this.id = id;
		this.priorita = priorita;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public EditDTO(long id, int priorita, String nome, String descrizione) {
		super();
		this.id = id;
		this.priorita = priorita;
		this.scadenza = null;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getPriorita() {
		return priorita;
	}
	
	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}
	
	public boolean isCompletato() {
		return completato;
	}
	
	public void setCompletato(boolean completato) {
		this.completato = completato;
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

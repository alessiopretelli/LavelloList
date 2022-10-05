package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private int priorita;
	@Column(nullable = false)
	private boolean completato;
	@ManyToOne
	@JoinColumn(name = "id_utente", nullable = false, updatable= false)
	private Utente utente;
	@Column(nullable = true)
	private LocalDate scadenza;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	
	public Task() {}
	
	public Task(int priorita, Utente utente, LocalDate scadenza, String nome, String descrizione) {
		super();
		this.priorita = priorita;
		this.utente = utente;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public Task(int priorita, Utente utente, String nome, String descrizione) {
		super();
		this.priorita = priorita;
		this.utente = utente;
		this.scadenza = null;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
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

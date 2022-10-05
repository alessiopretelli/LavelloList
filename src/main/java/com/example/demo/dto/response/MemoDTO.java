package com.example.demo.dto.response;

import java.time.LocalDate;

public class MemoDTO {
	private long id;
	private int priorita;
	private boolean completato;
	private String nome, descrizione;
	
	public MemoDTO(long id, int priorita, boolean completato, String nome, String descrizione) {
		super();
		this.id = id;
		this.priorita = priorita;
		this.completato = completato;
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

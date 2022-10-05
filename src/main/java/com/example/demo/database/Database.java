package com.example.demo.database;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.response.TaskDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;

public class Database {
	
	private static Database instance = new Database();
	
	private Database() {}

	public static Database getInstance() {
		return instance;
	}
	
	private List<Utente> utenti = new ArrayList<Utente>();
	private List<Task> tasks = new ArrayList<Task>();
	
	private static long idUtenteGen = 1;
	private static long idTaskGen = 1;
	
	public boolean registraUtente(Utente utente) {
		
		for(Utente u : utenti) {
			
			if(u.getUsername().equals(utente.getUsername())) return false;
			
		}

		utente.setId(idUtenteGen++);
		utenti.add(utente);
		return true;
	}
	
	public Utente login(String username, String password) {
		
		for(Utente u : utenti) {
			
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) return u;
			
		}

		return null;
	}
	
	public List<TaskDTO> getTasksByUser(Utente utente) {
		List<Task> tasksU = new ArrayList<>();
		List<TaskDTO> tasksD = new ArrayList<>();
		
		for(Task t : tasks) {
			
			if(t.getUtente().getId() == utente.getId()) tasksU.add(t);
			
		}
		
		for(Task t : tasksU) {
			
			tasksD.add(new TaskDTO(t.getId(), t.getPriorita(), t.isCompletato(), t.getScadenza(), t.getNome(), t.getDescrizione()));
			
		}

		return tasksD;
	}
	
	public boolean getTaskById(long id) {
		
		for(Task t : tasks) {
			
			if(t.getId() == id) return true;
			
		}
		
		return false;
	}
	
	public Utente getUtenteById(long id) {
		
		for(Utente u : utenti) {
			
			if(u.getId() == id) return u;
			
		}
		
		return null;
		
	}
	
	public boolean addTask(int priorita, LocalDate scadenza, String nome, String descrizione, long idUtente) {
		Utente u = getUtenteById(idUtente);
		
		if(u == null) {
			return false;
		} else {
			Task t=new Task(priorita, u, scadenza, nome, descrizione);
			t.setId(idTaskGen++);
			tasks.add(t);
			return true;
		}
		
	}
	
	public void checkTask(long id) {
		
		for(Task t : tasks) {
			
			if(t.getId() == id) {
				t.setCompletato(true);
				return;
			}
			
		}
		
	}
	
	public void editTask(long id, int priorita, LocalDate scadenza, String nome, String descrizione) {
		
		for(Task t : tasks) {
			
			if(t.getId() == id) {
				t.setPriorita(priorita);
				t.setScadenza(scadenza);
				t.setNome(nome);
				t.setDescrizione(descrizione);
				return;
			}
			
		}
		
	}
	
}

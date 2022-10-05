package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.TaskDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UtenteRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository repo;
	
	public boolean addTask(int priorita, LocalDate scadenza, String nome, String descrizione, Utente utente) {
		
		try {
			Task task = new Task(priorita, utente, scadenza, nome, descrizione);
			task = repo.save(task);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
	
	public List<TaskDTO> getTasksByUser(Utente utente) {
		List<Task> tasksU = repo.getTasksByUser(utente);
		List<TaskDTO> tasksD = new ArrayList<>();
		
		for(Task t : tasksU) {
			
			tasksD.add(new TaskDTO(t.getId(), t.getPriorita(), t.isCompletato(), t.getScadenza(), t.getNome(), t.getDescrizione()));
			
		}

		return tasksD;
	}
	
	public boolean getTaskById(long id) {
		Task task = repo.getTaskById(id);
		
		if(task != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean checkTask(long id) {
		Task task = repo.getTaskById(id);
		
		if(task != null) {
			task.setCompletato(true);
			task = repo.save(task);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean editTask(long id, int priorita, LocalDate scadenza, String nome, String descrizione) {
		Task task = repo.getTaskById(id);
		
		if(task != null) {
			task.setPriorita(priorita);
			task.setScadenza(scadenza);
			task.setNome(nome);
			task.setDescrizione(descrizione);
			task = repo.save(task);
			return true;
		} else {
			return false;
		}
		
	}
	
}

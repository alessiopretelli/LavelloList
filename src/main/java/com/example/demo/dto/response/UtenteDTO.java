package com.example.demo.dto.response;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.utilities.Utilities;
import com.example.demo.model.Task;

public class UtenteDTO {
	
	private long id;
	private String nome, cognome, username;
	private List<MemoDTO> memos = new ArrayList<>();
	private List<TaskDTO> tasksToDo = new ArrayList<>();
	private List<TaskDTO> tasksDone = new ArrayList<>();
	private List<TaskDTO> tasksExpired = new ArrayList<>();

	public UtenteDTO() {}
	
	public UtenteDTO(String nome, String cognome, String username, List<TaskDTO> tasks, long id) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username.toLowerCase().trim();
		
		this.memos = Utilities.getMemos(tasks);
		List<TaskDTO> tasksFiltered = Utilities.getTasks(tasks);
		
		for(TaskDTO t : tasksFiltered) {
			
			if(t.isCompletato()) {
				this.tasksDone.add(t);
			} else if(t.getScadenza().isBefore(LocalDate.now())) {
				this.tasksExpired.add(t);
			} else {
				this.tasksToDo.add(t);
			}
			
		}
		
	}

	public List<MemoDTO> getMemos() {
		return memos;
	}

	public void setMemos(List<MemoDTO> memos) {
		this.memos = memos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		this.username = username.toLowerCase().trim();
	}

	public List<TaskDTO> getTasksToDo() {
		return tasksToDo;
	}

	public void setTasksToDo(List<TaskDTO> tasksToDo) {
		this.tasksToDo = tasksToDo;
	}

	public List<TaskDTO> getTasksDone() {
		return tasksDone;
	}

	public void setTasksDone(List<TaskDTO> tasksDone) {
		this.tasksDone = tasksDone;
	}

	public List<TaskDTO> getTasksExpired() {
		return tasksExpired;
	}

	public void setTasksExpired(List<TaskDTO> tasksExpired) {
		this.tasksExpired = tasksExpired;
	}
	
}

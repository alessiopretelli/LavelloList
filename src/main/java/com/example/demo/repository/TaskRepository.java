package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.response.TaskDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("select u from Utente u where u.username = :username and u.password = :password")
	public Utente login(String username, String password);
	
	@Query("select t from Task t where t.utente = :utente")
	public List<Task> getTasksByUser(Utente utente);
	
	@Query("select t from Task t where t.id = :id")
	public Task getTaskById(long id);
	
}

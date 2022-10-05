package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.utente.EditUtenteDTO;
//import com.example.demo.database.Database;
import com.example.demo.dto.request.utente.LoginDTO;
import com.example.demo.dto.request.utente.RegistrazioneDTO;
import com.example.demo.dto.response.TaskDTO;
import com.example.demo.dto.response.UtenteDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Utente;
import com.example.demo.services.TaskService;
import com.example.demo.services.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteController {
	@Autowired
	TaskService taskService;
	@Autowired
	UtenteService userService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity login(@RequestBody LoginDTO request) {
		Utente utente = userService.login(request.getUsername(), request.getPassword());
			
		if(utente != null) {
			List<TaskDTO> tasks = taskService.getTasksByUser(utente);
			UtenteDTO utenteRes = new UtenteDTO(utente.getNome(), utente.getCognome(), utente.getUsername(), tasks, utente.getId());
			return ResponseEntity.status(HttpStatus.OK).body(utenteRes);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/registrazione")
	public ResponseEntity registrazione(@RequestBody RegistrazioneDTO request) {
		
		if(request.isValid()) {
			Utente utente = new Utente(request.getNome(), request.getCognome(), request.getUsername(), request.getPassword());
			
			if(userService.register(utente) != null) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
			
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/editUtente")
	public ResponseEntity editUtente(@RequestBody EditUtenteDTO request) {
		
		if(request.isValid()) {
			
			if(userService.edit(request.getIdUtente(), request.getNome(), request.getCognome(), request.getOldPassword(), request.getNewPassword())) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
			
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
}

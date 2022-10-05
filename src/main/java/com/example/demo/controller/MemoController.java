package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.database.Database;
import com.example.demo.dto.request.utente.AddDTO;
import com.example.demo.dto.request.utente.CheckDTO;
import com.example.demo.dto.request.utente.EditDTO;
import com.example.demo.model.Utente;
import com.example.demo.services.TaskService;
import com.example.demo.services.UtenteService;
import com.example.demo.utilities.Utilities;

@RestController
@RequestMapping("/memo")
public class MemoController {
	@Autowired
	TaskService taskService;
	@Autowired
	UtenteService userService;

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public ResponseEntity addTask(@RequestBody AddDTO request) {
		Utente utente = userService.userById(request.getIdUtente());
		
		if(Utilities.checkErrors(request.getPriorita(), request.getNome(), request.getDescrizione()) || utente == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		if(taskService.addTask(request.getPriorita(), request.getScadenza(), request.getNome(), request.getDescrizione(), utente)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public ResponseEntity deleteMemo(@RequestBody CheckDTO request) {
		
		if(taskService.checkTask(request.getId())) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public ResponseEntity editMemo(@RequestBody EditDTO request) {
		
		if(Utilities.checkErrors(request.getPriorita(), request.getNome(), request.getDescrizione())) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		if(taskService.editTask(request.getId(), request.getPriorita(), request.getScadenza(), request.getNome(), request.getDescrizione())) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
}

package com.example.demo.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.response.MemoDTO;
import com.example.demo.dto.response.TaskDTO;

public class Utilities {
	
	public static boolean checkErrors(int priorita, LocalDate scadenza, String nome, String descrizione) {
		
		if(priorita > 3 || priorita <= 0 || scadenza.isBefore(LocalDate.now()) || nome.length() > 255 || descrizione.length() > 255) {
			return true;
		}
		
		return false;
	}
	
	public static boolean checkErrors(int priorita, String nome, String descrizione) {
		
		if(priorita > 3 || priorita <= 0 || nome.length() > 255 || descrizione.length() > 255) {
			return true;
		}
		
		return false;
	}
	
	public static List<TaskDTO> getTasks(List<TaskDTO> tasksToFilter) {
		List<TaskDTO> tasks = new ArrayList<>();
		
		for(TaskDTO tf : tasksToFilter) {
			
			if(tf.getScadenza() != null) {
				tasks.add(tf);
			}
			
		}
		
		TaskDTO t;
		
		for(int i = 0; i < tasks.size(); i++) {
			
			for(int j = (i + 1); j < tasks.size(); j++) {
				
				if(tasks.get(i).getPriorita() <= tasks.get(j).getPriorita()) {
					t = tasks.get(i);
					tasks.set(i, tasks.get(j));
					tasks.set(j, t);
				}
				
			}
			
		}
		
		t = null;
		
		for(int i = 0; i < tasks.size(); i++) {
			
			for(int j = (i + 1); j < tasks.size(); j++) {
				
				if(tasks.get(i).getPriorita() <= tasks.get(j).getPriorita() && tasks.get(i).getScadenza().isAfter(tasks.get(j).getScadenza())) {
					t = tasks.get(i);
					tasks.set(i, tasks.get(j));
					tasks.set(j, t);
				}
				
			}
			
		}
		
		return tasks;
	}
	
	public static List<MemoDTO> getMemos(List<TaskDTO> tasksToFilter) {
		List<MemoDTO> memos = new ArrayList<>();
		
		for(TaskDTO tf : tasksToFilter) {
			
			if(tf.getScadenza() == null && tf.isCompletato() == false) {
				memos.add(new MemoDTO(tf.getId(), tf.getPriorita(), tf.isCompletato(), tf.getNome(), tf.getDescrizione()));
			}
			
		}
		
		MemoDTO m;
		
		for(int i = 0; i < memos.size(); i++) {
			
			for(int j = (i + 1); j < memos.size(); j++) {
				
				if(memos.get(i).getPriorita() <= memos.get(j).getPriorita()) {
					m = memos.get(i);
					memos.set(i, memos.get(j));
					memos.set(j, m);
				}
				
			}
			
		}
		
		return memos;
	}
	
}

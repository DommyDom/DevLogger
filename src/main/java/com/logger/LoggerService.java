package com.logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
	
	@Autowired
	private LoggerRepository repo;
	
	
	public List<Log> getLogs(){
		return repo.findAll();
	}
	
	public Log getLog(int index) {
		long dIndex = index;
		return repo.findById(dIndex).get();
		
		
	}
	
	public void addLog(Log log) {
		repo.save(log);
	}
	
	public void deleteLog(int id) {
		long dId = id;
		repo.deleteById(dId);
	}
	
	public void editLog(int id, Log log) {
		repo.save(log);
	}
	
}

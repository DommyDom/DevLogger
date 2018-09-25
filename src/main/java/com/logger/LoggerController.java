package com.logger;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
	
	@Autowired
	LoggerService loggerService;
	
	
	@RequestMapping(value = "/api/logs", method = RequestMethod.GET)
	@ResponseBody
	public List<Log> getLogs() {
		return loggerService.getLogs();
	}
	
	@RequestMapping(value = "/api/logs/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Log getLog(@PathVariable("id") int id) {
		return loggerService.getLog(id);
	}
	
	@RequestMapping(value ="/api/logs", method = RequestMethod.POST)
	@ResponseBody
	public Log addLog(@RequestBody Log log, Principal principal) {
		Log newLog = new Log(log.getTitle(),principal.getName(),log.getLog());
		System.out.println();
		loggerService.addLog(newLog);
		return newLog;
	}
	
	@RequestMapping(value ="/api/logs/{id}",method = RequestMethod.DELETE)
	public Log deleteLog(@PathVariable("id") int id) {
		loggerService.deleteLog(id);
		return null;
	}
	
	@RequestMapping(value ="/api/logs/{id}",method = RequestMethod.PUT)
	public Log editLog(@PathVariable("id") int id, @RequestBody Log log) {
		loggerService.editLog(id, log);
		return log;
	}
	
	
	
}

package com.logger.api;

import java.security.Principal;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan("org.springframework.security.samples.mvc")
@RestController
public class LoggerController implements WebMvcConfigurer {
	
	@Autowired
	LoggerService loggerService ;
	
	
	@Autowired
    private SimpMessagingTemplate template;
	
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
		System.out.println("pls print :)");
		
		Log newLog = new Log(log.getTitle(),principal.getName(),log.getLog(),new Date());
		
		loggerService.addLog(newLog);
		template.convertAndSend("/topic/log",newLog);
		
		return null;
	}
	
	@RequestMapping(value ="/api/logs/{id}",method = RequestMethod.DELETE)
	public Log deleteLog(@PathVariable("id") int id) {
		loggerService.deleteLog(id);
		return null;
	}
	
	@RequestMapping(value ="/api/logs/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Log editLog(@PathVariable("id") int id, @RequestBody Log log) {
		log.setEditDate(new Date());
		System.out.println(log.getDate());
		loggerService.editLog(id, log);
		return log;
	}
	
	
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/login").setViewName("login");
	        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    }
	
}

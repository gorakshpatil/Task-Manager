package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000") 
public class TaskController {

	@Autowired
	TaskService crepo;
	
	@GetMapping
	public List<Task>getAllTask(){
		return crepo.getAllTask();
	}
	
	@GetMapping("/{id}")
	public Optional<Task> getById(@PathVariable Long id) {
		return crepo.getById(id);
	}
	
	@PostMapping
	public Task createTask(@RequestBody Task s) {
		return crepo.createTask(s);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable long id) {
		 crepo.deleteTask(id);
	}
	 
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedtask) {
		return crepo.updateTask(id, updatedtask);
	}
	
	
}

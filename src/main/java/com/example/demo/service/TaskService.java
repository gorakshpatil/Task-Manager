package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	
		@Autowired
		TaskRepository service;

		public List<Task> getAllTask(){
			return service.findAll();
		}
		
		public Optional<Task> getById(long id) {
			return service.findById(id);
		}
		
		public Task createTask(Task s) {
			return service.save(s);
		}
		
		public void deleteTask(Long id) {
			 service.deleteById(id);
		}
		
		public Task updateTask(Long id , Task updatedtask) {
				Task exesting=service.findById(id).orElseThrow();
				exesting.setTitle(updatedtask.getTitle());
				exesting.setStatus(updatedtask.getStatus());
				exesting.setPriority(updatedtask.getPriority());
				exesting.setDuedate(updatedtask.getDuedate());
			return	service.save(exesting);
		}
		
		
}

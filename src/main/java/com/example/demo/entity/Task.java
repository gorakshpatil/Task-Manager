package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	public enum Status{
		TODO, IN_PROGRESS,DONE
	}
	
	public enum Priority {
        LOW, MEDIUM, HIGH
    }
	
	@Enumerated(EnumType.STRING)
	private Priority priority =Priority.MEDIUM;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.TODO;
	
	@Column
	private LocalDate duedate;
	
	@Column
	private LocalDateTime createdAt= LocalDateTime.now();

}

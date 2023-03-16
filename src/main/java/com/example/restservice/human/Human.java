package com.example.restservice.human;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.restservice.role.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document()
public class Human {
	@Id
	private String id;

	@NotBlank
	@Size(max = 100)
	private String username;

	@Size(max = 20)
	private String gender;

	private Integer step;

	@NotBlank
	@Size(max = 120)
	private String password;

    private String dadId;

    private String momId;
    
}
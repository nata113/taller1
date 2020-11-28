package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectTaskDTO;
import com.example.demo.servicio.ProjectTaskServicio;


@RestController
@RequestMapping("/task")
public class ProjectTaskControlador {

	@Autowired
	private ProjectTaskServicio projectTaskServicio;
	
	@PostMapping
	public ResponseEntity<ProjectTaskDTO> crearProjectTask(@RequestBody ProjectTaskDTO projectTaskDTO){
		if(projectTaskServicio.crearProjectTask(projectTaskDTO)) {
			return new ResponseEntity<ProjectTaskDTO>(projectTaskDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ProjectTaskDTO>(HttpStatus.BAD_REQUEST);
		}
	}
}

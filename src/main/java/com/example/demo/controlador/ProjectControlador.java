package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.servicio.ProjectServicio;

@RestController
@RequestMapping("/project")
public class ProjectControlador {
	
	@Autowired
	private ProjectServicio projectServicio;
	
	@PostMapping
	public ResponseEntity<ProjectDTO> crearProject(@RequestBody ProjectDTO projectDTO){
		if(projectServicio.crearProject(projectDTO)) {
			return new ResponseEntity<ProjectDTO>(projectDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ProjectDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> obtenerProyectos(){
		return new ResponseEntity<List<ProjectDTO>>(projectServicio.obtenerTodos(), HttpStatus.OK);
	}
}

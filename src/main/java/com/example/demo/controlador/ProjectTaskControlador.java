package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.ProjectTask;
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
	
	
	@GetMapping("/project/{projectIdentifier}")
	public ResponseEntity<List<ProjectTask>> obtenerTareasProyecto(@PathVariable String projectIdentifier) {
		List<ProjectTask> projectTasks = projectTaskServicio.obtenerTareasProyecto(projectIdentifier);
		
		if(projectTasks.isEmpty()) {
			return new ResponseEntity<List<ProjectTask>>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<ProjectTask>>(projectTasks, HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/hours/project/{projectIdentifier}")
	public ResponseEntity<Double> obtenerHorasProyecto(@PathVariable String projectIdentifier){
		return new ResponseEntity<Double>(projectTaskServicio.obtenerHorasProyecto(projectIdentifier), HttpStatus.OK);
	}
	
	
	@GetMapping("/hours/project/{projectIdentifier}/{status}")
	public ResponseEntity<Double> obtenerHorasProyectoPorStatus(@PathVariable String projectIdentifier, @PathVariable String status){
		return new ResponseEntity<Double>(projectTaskServicio.obtenerHorasProyectoPorStatus(projectIdentifier, status), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{idTask}/{projectIdentifier}")
	public ResponseEntity<Boolean> eliminarTarea(@PathVariable Long idTask, @PathVariable String projectIdentifier){
		return new ResponseEntity<Boolean>(projectTaskServicio.eliminarTarea(projectIdentifier, idTask), HttpStatus.OK);
	}
}

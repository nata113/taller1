package com.taller.core.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.core.dto.BacklogDTO;
import com.taller.core.servicio.BacklogServicio;

@RestController
@RequestMapping("/backlog")
public class BackLogControlador {

	@Autowired
	private BacklogServicio backlogServicio;
	
	@PostMapping
	public ResponseEntity<BacklogDTO> adicionarBacklog(@RequestBody BacklogDTO backlogDTO){
		if(backlogServicio.crearBacklog(backlogDTO)) {
			return new ResponseEntity<BacklogDTO>(backlogDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<BacklogDTO>(HttpStatus.BAD_REQUEST);
		}
	}
}

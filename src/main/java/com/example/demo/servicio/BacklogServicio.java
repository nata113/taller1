package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.dominio.Backlog;
import com.example.demo.dto.BacklogDTO;
import com.example.demo.repositorio.IBacklogRepositorio;

@Validated
@Service
public class BacklogServicio {
	
	@Autowired
	private IBacklogRepositorio backlogRepositorio;

	public boolean crearBacklog(BacklogDTO backlogDTO) {
		Backlog backlog = mapearAEntidad(backlogDTO);
		
		return null != backlogRepositorio.save(backlog);
	}
	
	private Backlog mapearAEntidad(BacklogDTO backlogDTO) {
		Backlog backlog = new Backlog();
		
		backlog.setProject(backlogDTO.getProject());
		backlog.setProjectIdentifier(backlogDTO.getProjectIdentifier());
		backlog.setProjectTasks(backlogDTO.getProjectTasks());
		
		return backlog;
	}
}

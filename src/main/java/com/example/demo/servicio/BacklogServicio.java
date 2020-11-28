package com.example.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Backlog;
import com.example.demo.dto.BacklogDTO;
import com.example.demo.repositorio.IBacklogRepositorio;

@Service
public class BacklogServicio {

	@Autowired
	private IBacklogRepositorio backlogRepositorio;

	public boolean crearBacklog(BacklogDTO backlogDTO) {
		Backlog backlog = mapearAEntidad(backlogDTO);

		try {
			backlogRepositorio.save(backlog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Backlog mapearAEntidad(BacklogDTO backlogDTO) {
		Backlog backlog = new Backlog();

		backlog.setId(backlogDTO.getId());
		backlog.setProject(backlogDTO.getProject());
		backlog.setProjectIdentifier(backlogDTO.getProjectIdentifier());
		backlog.setProjectTasks(backlogDTO.getProjectTasks());

		return backlog;
	}
}

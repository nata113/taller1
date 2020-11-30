package com.taller.core.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.core.dominio.Backlog;
import com.taller.core.dto.BacklogDTO;
import com.taller.core.repositorio.IBacklogRepositorio;

@Service
public class BacklogServicio {

	@Autowired
	private IBacklogRepositorio backlogRepositorio;

	public boolean crearBacklog(BacklogDTO backlogDTO) {
		Optional<Backlog> backlogBD = backlogRepositorio.findById(backlogDTO.getId());

		if (backlogBD.isPresent()) {
			System.out.println("===================================");
			System.out.println("Ya existe un Backlog con este ID");
			System.out.println("===================================");
			return false;
		}
		
		Backlog backlog = mapearAEntidad(backlogDTO);

		try {
			backlogRepositorio.save(backlog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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

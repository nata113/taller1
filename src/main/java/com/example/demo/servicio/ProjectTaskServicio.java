package com.example.demo.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.ProjectTask;
import com.example.demo.dto.ProjectTaskDTO;
import com.example.demo.repositorio.IProjectTaskRepositorio;

@Service
public class ProjectTaskServicio {

	@Autowired
	private IProjectTaskRepositorio projectTaskRepositorio;
	
	public boolean crearProjectTask(ProjectTaskDTO projectTaskDTO) {
		
		if(validar(projectTaskDTO)) {
			ProjectTask projectTask = mapearAEntidad(projectTaskDTO);

			try {
				projectTaskRepositorio.save(projectTask);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
		
	}

	private ProjectTask mapearAEntidad(ProjectTaskDTO projectTaskDTO) {
		ProjectTask projectTask = new ProjectTask();

		projectTask.setId(projectTaskDTO.getId());
		projectTask.setName(projectTaskDTO.getName());
		projectTask.setSummary(projectTaskDTO.getSummary());
		projectTask.setAcceptanceCriteria(projectTaskDTO.getAcceptanceCriteria());
		projectTask.setStatus(projectTaskDTO.getStatus());
		projectTask.setPriority(projectTaskDTO.getPriority());
		projectTask.setHours(projectTaskDTO.getHours());
		projectTask.setStartDate(projectTaskDTO.getStartDate());
		projectTask.setEndDate(projectTaskDTO.getEndDate());
		projectTask.setProjectIdentifier(projectTaskDTO.getProjectIdentifier());
		projectTask.setBacklog(projectTaskDTO.getBacklog());
		
		return projectTask;
	} 
	
	private boolean validar(ProjectTaskDTO projectTaskDTO) {
		if(null == projectTaskDTO.getId()) {
			return false;
		}
		Optional<ProjectTask> projectTaskBD = projectTaskRepositorio.findById(projectTaskDTO.getId());

		if (projectTaskBD.isPresent()) {
			return false;
		}
		
		return true;
		
	}
}

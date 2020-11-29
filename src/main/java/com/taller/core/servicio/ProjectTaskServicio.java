package com.taller.core.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.core.dominio.ProjectTask;
import com.taller.core.dto.ProjectTaskDTO;
import com.taller.core.repositorio.IProjectTaskRepositorio;

@Service
public class ProjectTaskServicio {

	@Autowired
	private IProjectTaskRepositorio projectTaskRepositorio;

	public boolean crearProjectTask(ProjectTaskDTO projectTaskDTO) {

		if (validar(projectTaskDTO)) {
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
		if (null == projectTaskDTO.getId()) {
			return false;
		}
		Optional<ProjectTask> projectTaskBD = projectTaskRepositorio.findById(projectTaskDTO.getId());

		if (projectTaskBD.isPresent()) {
			return false;
		}

		return true;
	}

	public List<ProjectTask> obtenerTareasProyecto(String projectIdentifier) {
		return projectTaskRepositorio.obtenerTareasPorProyecto(projectIdentifier);
	}

	public Double obtenerHorasProyecto(String projectIdentifier) {
		Double totalHoras = 0D;
		List<ProjectTask> projectTasks = projectTaskRepositorio.obtenerTareasExistentesPorProyecto(projectIdentifier);

		for (ProjectTask item : projectTasks) {
			if (!item.getStatus().equals("deleted")) {
				totalHoras += item.getHours();
			}
		}

		return totalHoras;
	}
	
	
	public Double obtenerHorasProyectoPorStatus(String projectIdentifier, String status) {
		Double totalHoras = 0D;
		List<ProjectTask> projectTasks = projectTaskRepositorio.obtenerTareasExistentesPorProyecto(projectIdentifier);

		for (ProjectTask item : projectTasks) {
			if (item.getStatus().equals(status)) {
				totalHoras += item.getHours();
			}
		}

		return totalHoras;
	}
	
	public boolean eliminarTarea(String projectIdentifier, Long id) {
		ProjectTask projectTaskEliminada = null;
		ProjectTask projectTaskBD = projectTaskRepositorio.obtenerTareaPorIdEIdentificador(projectIdentifier, id);
		
		if(null != projectTaskBD) {
			projectTaskBD.setStatus("deleted");
			
			
			projectTaskEliminada = projectTaskRepositorio.save(projectTaskBD);
		}
		
		return null != projectTaskEliminada;
	}
}

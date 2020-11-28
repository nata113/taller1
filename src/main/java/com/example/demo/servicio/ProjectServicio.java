package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Backlog;
import com.example.demo.dominio.Project;
import com.example.demo.dto.ProjectDTO;
import com.example.demo.repositorio.IBacklogRepositorio;
import com.example.demo.repositorio.IProjectRepositorio;

@Service
public class ProjectServicio {

	@Autowired
	private IProjectRepositorio projectRepositorio;
	
	@Autowired
	private IBacklogRepositorio backlogRepositorio;

	public boolean crearProject(ProjectDTO projectDTO) {
		Optional<Project> projectBD = projectRepositorio.findById(projectDTO.getId());

		if (projectBD.isPresent()) {
			return false;
		}

		Project project = mapearAEntidad(projectDTO);

		try {
			projectRepositorio.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Project mapearAEntidad(ProjectDTO projectDTO) {
		Project project = new Project();

		project.setId(projectDTO.getId());
		project.setProjectName(projectDTO.getProjectName());
		project.setProjectIdentifier(projectDTO.getProjectIdentifier());
		project.setDescription(projectDTO.getDescription());
		project.setStartDate(projectDTO.getStartDate());
		project.setEndDate(projectDTO.getEndDate());
		
		Optional<Backlog> backlog = backlogRepositorio.findById(projectDTO.getBacklog().getId());
		if(backlog.isPresent()) {
			project.setBacklog(backlog.get());
		}

		return project;
	}
	
	public List<ProjectDTO> obtenerTodos() {
		List<Project> projects = new ArrayList<>();
		List<ProjectDTO> projectsDTO = new ArrayList<>();
		Iterable<Project> iterable = projectRepositorio.findAll();
		
	    iterable.forEach(projects::add);
	    
	    for(Project item : projects) {
	    	ProjectDTO projectDTO = new ProjectDTO();
	    	
	    	projectDTO.setId(item.getId());
	    	projectDTO.setBacklog(item.getBacklog());
	    	projectDTO.setDescription(item.getDescription());
	    	projectDTO.setStartDate(item.getStartDate());
	    	projectDTO.setEndDate(item.getEndDate());
	    	projectDTO.setProjectIdentifier(item.getProjectIdentifier());
	    	projectDTO.setProjectName(item.getProjectName());
	    	
	    	projectsDTO.add(projectDTO);
	    }
		
	    return projectsDTO;
	}
}

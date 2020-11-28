package com.example.demo.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Project;
import com.example.demo.dto.ProjectDTO;
import com.example.demo.repositorio.IProjectRepositorio;

@Service
public class ProjectServicio {

	@Autowired
	private IProjectRepositorio projectRepositorio;

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
		project.setBacklog(projectDTO.getBacklog());

		return project;
	}
}

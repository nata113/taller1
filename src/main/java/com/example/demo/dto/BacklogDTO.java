package com.example.demo.dto;

import java.util.List;

import com.example.demo.dominio.Project;
import com.example.demo.dominio.ProjectTask;

public class BacklogDTO {

	private Long id;
	private String projectIdentifier;
	private Project project;
	private List<ProjectTask> projectTasks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<ProjectTask> getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(List<ProjectTask> projectTasks) {
		this.projectTasks = projectTasks;
	}
	
	
}

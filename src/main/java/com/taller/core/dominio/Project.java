package com.taller.core.dominio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Project {

	@Id
	private Long id;

	@NotBlank (message = "El atributo projectName no puede estar vacío")
	@Column(unique = true)
	private String projectName;

	//No se puede actualizar
	@NotBlank (message = "El atributo projectIdentifier no puede estar vacío")
	@Size(min = 5, max = 7, message = "Este valor debe tener entre 5 y 7 caracteres")
	@Column(unique = true)
	private String projectIdentifier;

	@NotBlank (message = "El atributo description no puede estar vacío")
	private String description;

	private Date startDate;

	private Date endDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="backlog_id", referencedColumnName = "id")
	private Backlog backlog;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
}

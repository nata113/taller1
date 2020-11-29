package com.taller.core.dto;

import java.util.Date;

import com.taller.core.dominio.Backlog;

public class ProjectTaskDTO {

	private Long id;
	private String name;
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private int priority;
	private Double hours;
	private Date startDate;
	private Date endDate;
	private String projectIdentifier;
	private Backlog backlog;

	public ProjectTaskDTO() {}
	
	public ProjectTaskDTO(Long id, String name, String summary, String acceptanceCriteria, String status, int priority,
			Double hours, Date startDate, Date endDate, String projectIdentifier, Backlog backlog) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.acceptanceCriteria = acceptanceCriteria;
		this.status = status;
		this.priority = priority;
		this.hours = hours;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectIdentifier = projectIdentifier;
		this.backlog = backlog;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
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

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

}

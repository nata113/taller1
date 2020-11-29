package com.taller.core.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.taller.core.dominio.Backlog;
import com.taller.core.dominio.ProjectTask;
import com.taller.core.dto.ProjectTaskDTO;
import com.taller.core.repositorio.IBacklogRepositorio;
import com.taller.core.repositorio.IProjectTaskRepositorio;
import com.taller.core.servicio.ProjectTaskServicio;

@SpringBootTest
public class ProjectTaskTest {

	@Autowired
	private IProjectTaskRepositorio projectTaskRepositorio; 
	
	@Autowired
	private ProjectTaskServicio projectTaskServicio;
	
	@Autowired
	private IBacklogRepositorio backlogRepositorio;
	
	@Test
	public void obtenerTareaPorIdEIdentificadorTest() {
		Long backlogId = 900L;
		Long projectTaskId = 800L;
		String projectIdentifier = "aaaaah";
		
		Backlog backlog = new Backlog();
		backlog.setId(backlogId);
		backlog.setProjectIdentifier("pruebaProjectIdentifier");
		
		ProjectTaskDTO projectTaskDTO = new ProjectTaskDTO();
		projectTaskDTO.setId(projectTaskId);
		projectTaskDTO.setProjectIdentifier(projectIdentifier);
		projectTaskDTO.setName("pruebaName");
		projectTaskDTO.setSummary("pruebaSummary");
		projectTaskDTO.setPriority(3);
		projectTaskDTO.setBacklog(backlogRepositorio.save(backlog));
		
		
		projectTaskServicio.crearProjectTask(projectTaskDTO);
		
		ProjectTask result = projectTaskRepositorio.obtenerTareaPorIdEIdentificador(projectIdentifier, projectTaskId);
		
		assertThat(result.getId() ,equalTo(projectTaskId));
	}
}

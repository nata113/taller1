package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dominio.Backlog;
import com.example.demo.dto.BacklogDTO;
import com.example.demo.repositorio.IBacklogRepositorio;
import com.example.demo.servicio.BacklogServicio;


@SpringBootTest
class BacklogTest {

	@Autowired
	private BacklogServicio backlogServicio;
	
	@Mock
	private IBacklogRepositorio backlogRepositorio;
	
	
	@Test
	public void testCrearBacklog() {
		BacklogDTO backlogDTO = new BacklogDTO();
		backlogDTO.setId(1L);
		backlogDTO.setProjectIdentifier("projectIdentifier");
		
		Backlog backlog = new Backlog();
		backlog.setId(1L);
		backlog.setProjectIdentifier("projectIdentifier");
		
		
		when(backlogRepositorio.save(backlog)).thenReturn(backlog);
		
		Boolean result = backlogServicio.crearBacklog(backlogDTO);
		
		assertThat(result == Boolean.TRUE);
		
	}
	
}

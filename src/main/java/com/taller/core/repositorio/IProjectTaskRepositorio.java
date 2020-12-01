package com.taller.core.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taller.core.dominio.ProjectTask;

@Repository
public interface IProjectTaskRepositorio extends CrudRepository<ProjectTask, Long>{
	
	@Query("SELECT b.projectTasks "
			+ "FROM Project p "
			+ "JOIN p.backlog b "
			+ "WHERE p.projectIdentifier = :projectIdentifier")
	List<ProjectTask> obtenerTareasPorProyecto(@Param("projectIdentifier") String projectIdentifier);
	
	
	@Query("SELECT p "
			+ "FROM ProjectTask p "
			+ "WHERE p.id = :id "
			+ "AND p.projectIdentifier = :projectIdentifier")
	ProjectTask obtenerTareaPorIdEIdentificador(@Param("projectIdentifier") String projectIdentifier, @Param("id") Long id);
}

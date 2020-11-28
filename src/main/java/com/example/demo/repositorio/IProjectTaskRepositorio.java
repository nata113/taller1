package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.ProjectTask;

@Repository
public interface IProjectTaskRepositorio extends CrudRepository<ProjectTask, Long>{

}

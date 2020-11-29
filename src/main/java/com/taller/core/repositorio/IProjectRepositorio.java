package com.taller.core.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller.core.dominio.Project;

@Repository
public interface IProjectRepositorio extends CrudRepository<Project, Long>{

}

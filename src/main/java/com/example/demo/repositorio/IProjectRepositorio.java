package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.Project;

@Repository
public interface IProjectRepositorio extends CrudRepository<Project, Long>{

}

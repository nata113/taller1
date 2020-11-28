package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.Persona;

@Repository
public interface IPersonaRepositorio extends CrudRepository<Persona, Long>{
	
}

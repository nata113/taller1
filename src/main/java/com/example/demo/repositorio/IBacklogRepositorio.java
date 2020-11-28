package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.Backlog;

@Repository
public interface IBacklogRepositorio extends CrudRepository<Backlog, Long> {

}

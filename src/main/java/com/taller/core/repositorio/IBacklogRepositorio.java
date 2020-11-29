package com.taller.core.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller.core.dominio.Backlog;

@Repository
public interface IBacklogRepositorio extends CrudRepository<Backlog, Long> {

}

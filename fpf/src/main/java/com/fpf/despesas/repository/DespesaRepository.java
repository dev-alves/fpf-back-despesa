package com.fpf.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.fpf.despesas.model.Despesa;

@RepositoryRestController
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}

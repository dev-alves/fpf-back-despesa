package com.fpf.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.fpf.despesas.model.TipoDespesa;

@RepositoryRestController
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

}

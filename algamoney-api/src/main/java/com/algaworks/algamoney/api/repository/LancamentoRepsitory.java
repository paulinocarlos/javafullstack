package com.algaworks.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.lancamento.LancamentoRepsitoryQuery;

public interface LancamentoRepsitory extends JpaRepository<Lancamento, Long>, LancamentoRepsitoryQuery  {

	
}

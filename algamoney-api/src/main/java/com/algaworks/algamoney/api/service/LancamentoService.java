package com.algaworks.algamoney.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.LancamentoRepsitory;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import com.algaworks.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepsitory lancamentoRepository;

	public Lancamento salvar(@Valid Lancamento lancamento) {
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(lancamento.getPessoa().getCodigo());

	    if (!pessoaOpt.isPresent() || pessoaOpt.get().isInativo()) {
	        throw new PessoaInexistenteOuInativaException();
	    }
	    
	    return lancamentoRepository.save(lancamento);
	}

}

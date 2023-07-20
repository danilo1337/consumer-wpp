package br.com.danilo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilo.dto.ImportacaoDTO;
import br.com.danilo.entity.Contato;
import br.com.danilo.negocio.ContatoNegocio;
import br.com.danilo.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoNegocio negocio;

	@Autowired
	private ContatoRepository repository;

	public void processar(ImportacaoDTO importacaoDTO) {
		try {
			
			List<Contato> contatos = negocio.preencherContatos(importacaoDTO);

			repository.saveAll(contatos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

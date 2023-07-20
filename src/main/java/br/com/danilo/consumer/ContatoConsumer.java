package br.com.danilo.consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import br.com.danilo.dto.ImportacaoDTO;
import br.com.danilo.entity.Contato;
import br.com.danilo.service.ContatoService;
import br.com.danilo.util.UtilCSV;
import br.com.danilo.util.UtilGZIP;
import br.com.danilo.util.UtilJson;

@Configuration
@EnableKafka
public class ContatoConsumer {
	
	@Autowired
	ContatoService service;
	
	@KafkaListener(topics = "contatos", groupId = "group-id")
	public void consumerContatos(String mensagem) throws IOException {
		
		ImportacaoDTO importacaoDTO = UtilJson.parseJsonToObject(mensagem, ImportacaoDTO.class);
		
		service.processar(importacaoDTO);
		
	    System.out.println("Mensagem recebida: " + mensagem);
	    
	}

}

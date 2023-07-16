package br.com.danilo.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@EnableKafka
public class ContatoConsumer {
	
	@KafkaListener(topics = "contatos", groupId = "group-id")
	public void consumerContatos(String mensagem) {
		
//		TesteDTO teste = UtilJson.parseJsonToObject(message, TesteDTO.class);
		
	    System.out.println("Mensagem recebida: " + mensagem);
	    
	}
}

package br.com.danilo.negocio;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.danilo.dto.ImportacaoDTO;
import br.com.danilo.entity.Contato;
import br.com.danilo.entity.Importacao;
import br.com.danilo.entity.Usuario;
import br.com.danilo.util.UtilCSV;
import br.com.danilo.util.UtilGZIP;

@Component
public class ContatoNegocio {
	
    public List<Contato> preencherContatos(ImportacaoDTO importacaoDTO) throws IOException {

        byte[] gzip = Base64.getDecoder().decode(importacaoDTO.getArquivoBase64());

        byte[] arquivo = UtilGZIP.decompressGzip(gzip);

        List<String> linhas =  new UtilCSV().lerTodasLinhas(arquivo);

        List<Contato> contatos = linhas.subList(1, linhas.size()).stream().map(linha -> {
            
        	String[] colunas = linha.split(";");
            
            return Contato.builder()
            			  .cpfCnpj(colunas[0])
            			  .nome(colunas[1])
            			  .telefone(colunas[2])
            			  .observacao(colunas[3])
            			  .usuario(Usuario.builder().id(importacaoDTO.getUsuario()).build())
            			  .importacao(Importacao.builder().id(importacaoDTO.getId()).build())
            			  .build();
            
        }).collect(Collectors.toList());

        return contatos;
    }
    
}

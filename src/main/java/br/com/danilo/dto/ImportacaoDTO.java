package br.com.danilo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportacaoDTO {
	
	private Long id;

    private String arquivoBase64;

    private String nomeArquivo;

    private Long usuario;
}

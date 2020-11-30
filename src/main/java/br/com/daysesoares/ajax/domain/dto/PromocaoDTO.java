package br.com.daysesoares.ajax.domain.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.daysesoares.ajax.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PromocaoDTO {

	@NotNull
	private Long id;
	
	@NotBlank(message = "Um titulo é requerio")
	private String titulo;
	
	private String descricao;
	
	@NotBlank(message = "O link da imagem é requerida")
	private String linkImagem;
	
	@NotNull(message = "O preço é requerido.")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal preco;
	
	@NotNull(message = "Uma categoria é requerida")
	private Categoria categoria;
	
}

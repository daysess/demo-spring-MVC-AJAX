package br.com.daysesoares.ajax.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

@Data
@Entity
@Table(name = "promocoes")
public class Promocao {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "link_promocao", nullable = false)
	private String linkPromocao;
	
	@Column(name = "site_promocao", nullable = false)
	private String site;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "link_imagem", nullable = false)
	private String linkImagem;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name = "preco_promocao", nullable = false)
	private BigDecimal preco;
	
	@Column(name = "total_likes")
	private int likes;
	
	@Column(name = "data_cadastro", nullable = false)
	private LocalDateTime dtCadastro;
	
	@ManyToOne
	@JoinColumn(name = "categoria_fk")
	private Categoria categoria;
	
}

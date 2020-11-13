package br.com.daysesoares.ajax.domain;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false, unique=true)
	private String titulo;
	
	@OneToMany(mappedBy = "categoria")
	private List<Promocao> promocoes;

}

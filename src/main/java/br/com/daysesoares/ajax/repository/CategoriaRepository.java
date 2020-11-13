package br.com.daysesoares.ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daysesoares.ajax.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

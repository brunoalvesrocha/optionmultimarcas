package br.com.optionmultimarcas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.optionmultimarcas.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{

	public List<Titulo> findByDescricaoContaining(String descricao);
}

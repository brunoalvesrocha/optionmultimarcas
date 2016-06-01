package br.com.optionmultimarcas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.optionmultimarcas.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByNameContaining(String descricao);
}

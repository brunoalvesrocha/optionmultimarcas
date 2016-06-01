package br.com.optionmultimarcas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.optionmultimarcas.model.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long>{

	public List<Provider> findByContactContaining(String descricao);
	
}

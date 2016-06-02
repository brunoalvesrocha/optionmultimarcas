package br.com.optionmultimarcas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.optionmultimarcas.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public List<Customer> findByNameContaining(String descricao);
}

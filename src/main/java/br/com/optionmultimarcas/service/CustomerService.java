package br.com.optionmultimarcas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.optionmultimarcas.model.Customer;
import br.com.optionmultimarcas.model.Provider;
import br.com.optionmultimarcas.repository.CustomerRepository;
import br.com.optionmultimarcas.repository.filter.Filter;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerDao;
	
	public void salvar(Customer customer) {
		customerDao.save(customer);
	}
	
	public List<Customer> filtrar(Filter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return customerDao.findByNameContaining(descricao);
	}
	
	public void excluir(Long id) {
		customerDao.delete(id);
	}
	
	public List<Customer> listarTodos() {
		return customerDao.findAll();
	}
}

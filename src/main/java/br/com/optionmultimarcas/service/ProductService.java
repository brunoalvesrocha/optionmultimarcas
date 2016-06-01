package br.com.optionmultimarcas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.optionmultimarcas.model.Product;
import br.com.optionmultimarcas.repository.ProductRepository;
import br.com.optionmultimarcas.repository.filter.Filter;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productDao;
	
	public void salvar(Product product) {
		try {
			productDao.save(product);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public void excluir(Long id) {
		productDao.delete(id);
	}
	
	public List<Product> filtrar(Filter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return productDao.findByNameContaining(descricao);
	}
	
}

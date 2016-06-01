package br.com.optionmultimarcas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.optionmultimarcas.model.Provider;
import br.com.optionmultimarcas.repository.ProviderRepository;
import br.com.optionmultimarcas.repository.filter.Filter;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerDao;
	
	public void salvar(Provider provider) {
			providerDao.save(provider);
	}

	public List<Provider> filtrar(Filter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao(); 
		return providerDao.findByContactContaining(descricao);
	}

	public void excluir(Long id) {
		providerDao.delete(id);
	}

	public List<Provider> listaTodos() {
		return providerDao.findAll();
	}
}

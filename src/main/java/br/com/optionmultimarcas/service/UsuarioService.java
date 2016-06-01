package br.com.optionmultimarcas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.optionmultimarcas.model.Usuario;
import br.com.optionmultimarcas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario autentica(Usuario usuario) {
		Usuario usr = usuarioRepository.findByUserAndPassword(usuario.getUser(), usuario.getPassword());
		return usr;
	}
}

package br.com.optionmultimarcas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.optionmultimarcas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByUserAndPassword(String email, String password);

	
}

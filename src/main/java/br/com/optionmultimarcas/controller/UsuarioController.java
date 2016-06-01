package br.com.optionmultimarcas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.optionmultimarcas.model.Usuario;
import br.com.optionmultimarcas.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/loginForm")
	public String formulario() {
		return "usuario/login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		System.out.println("Usuario: " + usuario.getUser() + " senha: " + usuario.getPassword());
		Usuario usr = usuarioService.autentica(usuario);
		if(usr != null) {
			session.setAttribute("usuarioLogado", usr);
			return "redirect:/products/";
		}
		return "redirect:loginForm";
	}
}

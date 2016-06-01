package br.com.optionmultimarcas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.optionmultimarcas.model.Provider;
import br.com.optionmultimarcas.repository.filter.Filter;
import br.com.optionmultimarcas.service.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	
	private static final String PROVIDER_REGISTER = "provider/Register";
	private static final String PROVIDER_SEARCH = "provider/Search";
	
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(PROVIDER_REGISTER);
		mv.addObject(new Provider());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Provider provider, Errors errors, RedirectAttributes attributes){
		if(errors.hasErrors()) {
			return PROVIDER_REGISTER;
		}
		providerService.salvar(provider);
		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
		return "redirect:/providers/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") Filter filtro) {
		List<Provider> allProviders = providerService.filtrar(filtro);
		ModelAndView mv = new ModelAndView(PROVIDER_SEARCH);
		mv.addObject("providers", allProviders);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Provider provider) {
		ModelAndView mv = new ModelAndView(PROVIDER_REGISTER);
		mv.addObject(provider);
		return mv;
	}
	
	@RequestMapping(value="{id}" ,method= RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		providerService.excluir(id);
		attributes.addFlashAttribute("mensagem", "Fornecedor excluido com sucesso!");
		return "redirect:/providers";
	}
}

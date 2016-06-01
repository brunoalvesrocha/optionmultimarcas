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

import br.com.optionmultimarcas.model.Product;
import br.com.optionmultimarcas.model.Provider;
import br.com.optionmultimarcas.repository.filter.Filter;
import br.com.optionmultimarcas.service.ProductService;
import br.com.optionmultimarcas.service.ProviderService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private static final String PRODUCT_REGISTER = "product/Register";
	private static final String PRODUCT_VIEW = "product/Search";
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(PRODUCT_REGISTER);
		mv.addObject(new Product());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Product product, Errors errors, RedirectAttributes attributes){
		
		if(errors.hasErrors()) return PRODUCT_REGISTER;
		try {
			productService.salvar(product);
			attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
			return "redirect:/products/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("aquisitionDate", null, e.getMessage());
			return PRODUCT_REGISTER;
		}
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") Filter filtro) {
		List<Product> allProducts = productService.filtrar(filtro);
		ModelAndView mv = new ModelAndView(PRODUCT_VIEW);
		mv.addObject("products", allProducts);
		return mv;
	}

	@ModelAttribute("providers")
		public List<Provider> allProviders() {
			return providerService.listaTodos();
		}
	
	@RequestMapping(value = "{id}")
	public ModelAndView edicao(@PathVariable("id") Product product) {
		ModelAndView mv = new ModelAndView(PRODUCT_REGISTER);
		mv.addObject(product);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		productService.excluir(id);
		attributes.addFlashAttribute("mensagem", "Produto excluido com sucesso!");
		return "redirect:/products";
	}
}

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

import br.com.optionmultimarcas.model.Customer;
import br.com.optionmultimarcas.repository.filter.Filter;
import br.com.optionmultimarcas.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private static final String CUSTOMER_REGISTER = "customer/Register";
	private static final String CUSTOMER_SEARCH = "customer/Search";
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CUSTOMER_REGISTER);
		mv.addObject(new Customer());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Customer customer, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return CUSTOMER_REGISTER;
		}
		customerService.salvar(customer);
		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
		return "redirect:/customers/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") Filter filtro) {
		List<Customer> allCustomers = customerService.filtrar(filtro);
		ModelAndView mv = new ModelAndView(CUSTOMER_SEARCH);
		mv.addObject("customers", allCustomers);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Customer customer) {
		ModelAndView mv = new ModelAndView(CUSTOMER_REGISTER);
		mv.addObject(customer);
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		customerService.excluir(id);
		attributes.addFlashAttribute("mensagem", "Cliente excluido com sucesso!");
		return "redirect:/customers";	
		}
}

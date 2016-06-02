package br.com.optionmultimarcas.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Sale {

	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Product> product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buyingCustomer_id", referencedColumnName = "id")
	private List<BuyingCustomer> buyingCustomer;
}

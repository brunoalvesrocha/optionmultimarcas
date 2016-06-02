package br.com.optionmultimarcas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The product name is not be empty...")
	private String name;
	private String description;
	
	@NotNull(message = "The aquisition date of the product is not be empty...")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar aquisitionDate;
	
	@NotNull(message = "The purchase price of product is not be empty...")
	@DecimalMin(value = "0.01", message = "The price may not be less 0,01")
	@DecimalMax(value = "9999999.99", message = "The price may not be higher 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private double purchasePrice;
	
	@NotNull(message = "The purchase price of product is not be empty...")
	@DecimalMin(value = "0.01", message = "The price may not be less 0,01")
	@DecimalMax(value = "9999999.99", message = "The price may not be higher 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private double saleValue;
	
	@NotEmpty(message = "The model of product is not be empty...")
	private String model;
	
	@NotNull(message = "The amount of product is not be empty...")
	private Integer amount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provider_id", referencedColumnName = "id")
	private Provider provider;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String description, Calendar aquisitionDate, double purchasePrice, double saleValue,
			String model, Integer amount, Provider provider) {
		this.name = name;
		this.description = description;
		this.aquisitionDate = aquisitionDate;
		this.purchasePrice = purchasePrice;
		this.saleValue = saleValue;
		this.model = model;
		this.amount = amount;
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getAquisitionDate() {
		return aquisitionDate;
	}

	public void setAquisitionDate(Calendar aquisitionDate) {
		this.aquisitionDate = aquisitionDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Provider getProvider() {
		return provider;
	}

	public Double getSumProft() {
		return saleValue - purchasePrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

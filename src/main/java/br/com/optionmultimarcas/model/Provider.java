package br.com.optionmultimarcas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar registerDate = Calendar.getInstance();
	
	@NotEmpty(message = "The contact name is necessary.")
	private String contact;
	
	@NotEmpty(message = "The store name is necessary.")
	private String store;
	
	@Email
	@NotEmpty(message = "The field email is necessary.")
	private String email;
	
	private String accountName;
	private String phone;
	private String bank;
	private String agency;
	private String account;
	private String address;
	private String offeredProducts;
	private String paymentType;
	private String website;
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}
	
	public Provider(Calendar registerDate, String contact, String store, String email, String bank, String agency,
			String account, String address, String offeredProducts, String paymentType, String website, String phone,
			String accountName) {

		this.registerDate = registerDate;
		this.contact = contact;
		this.store = store;
		this.email = email;
		this.bank = bank;
		this.agency = agency;
		this.account = account;
		this.address = address;
		this.offeredProducts = offeredProducts;
		this.paymentType = paymentType;
		this.website = website;
		this.phone = phone;
		this.accountName = accountName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOfferedProducts() {
		return offeredProducts;
	}
	public void setOfferedProducts(String offeredProducts) {
		this.offeredProducts = offeredProducts;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
		Provider other = (Provider) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

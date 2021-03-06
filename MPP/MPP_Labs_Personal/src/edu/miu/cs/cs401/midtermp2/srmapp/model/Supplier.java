package edu.miu.cs.cs401.midtermp2.srmapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supplier {

	private String supplierId;
	private String supplierName;
	private List<Product> products;
	
	public Supplier(String supplierId, String supplierName, Long productNumber, double unitPrice, String productName, LocalDate dateSupplied,Integer  quantityInStock) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.products = new ArrayList<Product>();
		this.products.add(new Product(productNumber, unitPrice, productName, dateSupplied, quantityInStock,this));
	}
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", products=" + products + "]";
	}
	
	
	
}

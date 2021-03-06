package edu.miu.cs.cs401.midtermp2.srmapp.model;

import java.time.LocalDate;

public class Product {

	private Long productNumber;
	private Double unitPrice;
	private String productName;
	private LocalDate dateSuplied;
	private Integer quantityInStock;
	private Supplier supplier;
	
	public Product(Long productNumber, Double unitPrice, String productName, LocalDate dateSuplied,
			Integer quantityInStock, Supplier supplier) {
		this.productNumber = productNumber;
		this.unitPrice = unitPrice;
		this.productName = productName;
		this.dateSuplied = dateSuplied;
		this.quantityInStock = quantityInStock;
		this.supplier = supplier;
	}
	
	public Long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDate getDateSuplied() {
		return dateSuplied;
	}
	public void setDateSuplied(LocalDate dateSuplied) {
		this.dateSuplied = dateSuplied;
	}
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", unitPrice=" + unitPrice + ", productName=" + productName
				+ ", dateSuplied=" + dateSuplied + ", quantityInStock=" + quantityInStock + "]";
	}
	
	
	
}

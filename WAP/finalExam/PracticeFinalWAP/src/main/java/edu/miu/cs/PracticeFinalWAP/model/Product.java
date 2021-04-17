package edu.miu.cs.PracticeFinalWAP.model;

import java.time.LocalDate;

public class Product {

    private String productId;
    private String name;
    private Double unitPrice;
    private Integer qty;
    private LocalDate dateSupplied;
    private Supplier supplier;

    public Product(){}
    public Product(String productId, String name, Double unitPrice, Integer qty, LocalDate dateSupplied, Supplier supplier) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

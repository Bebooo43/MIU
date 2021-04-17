package edu.miu.cs.PracticeFinalWAP.repository;

import edu.miu.cs.PracticeFinalWAP.model.Product;

import java.util.List;
import java.util.Vector;

public class SRMRepository {

    private List<Product> products = new Vector();

    public SRMRepository(List<Product> data){
        this.products = data;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

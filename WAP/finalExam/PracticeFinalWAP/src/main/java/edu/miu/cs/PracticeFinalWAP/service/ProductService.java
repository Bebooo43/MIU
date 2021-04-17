package edu.miu.cs.PracticeFinalWAP.service;

import edu.miu.cs.PracticeFinalWAP.model.Product;
import edu.miu.cs.PracticeFinalWAP.repository.SRMRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private SRMRepository repository;

    public ProductService(List<Product> data){
        this.repository = new SRMRepository(data);
    }

    public List<Product> getAllProductsSorted(){
        return repository.getProducts().stream()
                .sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }
}

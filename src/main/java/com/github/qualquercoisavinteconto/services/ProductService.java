package com.github.qualquercoisavinteconto.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.dto.ProductDTO;
import com.github.qualquercoisavinteconto.mappers.ProductMapper;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.repositories.ProductRepository;
import com.github.qualquercoisavinteconto.requests.ProductSearchRequest;
import com.github.qualquercoisavinteconto.responses.ProductSearchResponse;

@Service
public class ProductService {

    private final ProductRepository repository;

    public Product findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public ProductService(ProductRepository repository)
    {
        this.repository = repository;
    }

    public List<ProductSearchResponse> search(ProductSearchRequest request) 
    {
        List<Product> products = repository.findAll();
        return products.stream()
            .map(ProductMapper::mapToSearchResponse)
            .collect(Collectors.toList());
    }

    public Product save(ProductDTO product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        return repository.save(newProduct);
    }

    public void update(Long id, ProductDTO productDTO) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

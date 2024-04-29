package com.github.qualquercoisavinteconto.mappers;

import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.responses.ProductSearchResponse;

public class ProductMapper 
{
    public static ProductSearchResponse mapToSearchResponse(Product product) 
    {
        ProductSearchResponse response = new ProductSearchResponse();
        response.setName(product.getName());
        return response;
    }    
}

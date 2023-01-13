package com.alpha.exam.exam.services;

import com.alpha.exam.exam.models.Product;
import com.alpha.exam.exam.models.ProductDto;

public interface ProductService {
  Iterable<ProductDto> getProductByContinent(String continent);
  ProductDto createProduct(Product product);
  ProductDto convertProduct(Product product);
}

package com.alpha.exam.exam.services;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.exam.exam.models.Product;
import com.alpha.exam.exam.models.ProductDto;
import com.alpha.exam.exam.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
  private DecimalFormat df = new DecimalFormat("###.000000");

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Iterable<ProductDto> getProductByContinent(String continent) {
    List<ProductDto> productDtoList = new ArrayList<ProductDto>();
     productRepository.findByContinent(continent).forEach(new Consumer<Product>() {
      @Override
      public void accept(Product product) {
        productDtoList.add(convertProduct(product));
      }
    });
    return productDtoList;
  }

  @Override
  public ProductDto createProduct(Product product) {
    return convertProduct(productRepository.save(product));
  }

  @Override
  public ProductDto convertProduct(Product product) {
    ProductDto productDto = new ProductDto();
    productDto.setId(product.getId());
    productDto.setPrice(product.getPrice());
    productDto.setContinent(product.getContinent());
    productDto.setMultiplier(product.getMultiplier());
    productDto.setCreatedAt(product.getCreatedAt().format(dtf));
    productDto.setMultipliedValue(Double.parseDouble(product.getPrice()) * Double.parseDouble(product.getMultiplier()));
    return productDto;
  }
  
}

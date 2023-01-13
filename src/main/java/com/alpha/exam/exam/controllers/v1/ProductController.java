package com.alpha.exam.exam.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.exam.exam.models.CreateProductDto;
import com.alpha.exam.exam.models.Product;
import com.alpha.exam.exam.models.ProductDto;
import com.alpha.exam.exam.services.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/product")
  public Iterable<ProductDto> getProducts(@RequestParam(required = false) String continent){
    return productService.getProductByContinent(continent);
  }

  @PostMapping(value="/product", consumes="application/json", produces="application/json")
  public ResponseEntity<ProductDto> createProduct(@RequestBody(required = true) CreateProductDto product) {
    Product newProduct = new Product();
    newProduct.setPrice(String.valueOf(product.getPrice()));
    newProduct.setContinent(product.getContinent());
    newProduct.setMultiplier(String.valueOf(product.getMultiplier()));
    ProductDto createdProduct = productService.createProduct(newProduct);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
  }
}

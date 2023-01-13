package com.alpha.exam.exam.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.alpha.exam.exam.models.Product;

public interface ProductRepository extends CrudRepository<Product, UUID> {
  Iterable<Product> findByContinent(String continent);
}

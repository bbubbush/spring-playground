package com.bbubbush.springplayground.service;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.entity.Product;
import com.bbubbush.springplayground.enums.Category;
import com.bbubbush.springplayground.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
  private final ProductRepository productRepository;
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findProductById(Long id) {
    return productRepository.findById(id)
      .orElse(Product.builder().build());
  }

  public Product save(String name, Category category) {
    return productRepository.save(
      Product.builder()
        .name(name)
        .category(category)
        .build());
  }
}

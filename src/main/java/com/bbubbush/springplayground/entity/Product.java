package com.bbubbush.springplayground.entity;

import com.bbubbush.springplayground.enums.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
  @Id @GeneratedValue
  private Long id;

  private String name;

  private Long price;
  @Enumerated(EnumType.STRING)
  private Category category;

  @Builder
  public Product(String name, Category category) {
    this.name = name;
    this.category = category;
  }
}

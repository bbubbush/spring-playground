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
  @Column(name = "product_id")
  private Long id;
  private String name;
  private Long price;
  @Enumerated(EnumType.STRING)
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  @Builder
  public Product(String name, Long price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }
}

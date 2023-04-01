package com.bbubbush.springplayground.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Order {
  @Id @GeneratedValue
  @Column(name = "order_id")
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @OneToMany(mappedBy = "order")
  private List<Product> products = new ArrayList<>();

  @Builder
  public Order(Member member) {
    this.member = member;
  }

  public void addProduct(Product product) {
    this.products.add(product);
  }
}

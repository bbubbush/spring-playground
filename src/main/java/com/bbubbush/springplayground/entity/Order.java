package com.bbubbush.springplayground.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue
  private Long orderId;
  @ManyToOne(fetch = FetchType.LAZY)
  private Member member;
//  @OneToMany(mappedBy = "id")
//  private List<Product> products;


}

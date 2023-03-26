package com.bbubbush.springplayground.entity;

import com.bbubbush.springplayground.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Product {
  @Id @GeneratedValue
  private Long id;

  private String name;

  private Long price;
  @Enumerated(EnumType.STRING)
  private Category category;
}

package com.bbubbush.springplayground.service;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.entity.Order;
import com.bbubbush.springplayground.entity.Product;
import com.bbubbush.springplayground.enums.Category;
import com.bbubbush.springplayground.repository.OrderRepository;
import com.bbubbush.springplayground.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
  private final OrderRepository orderRepository;
  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findOrderById(Long id) {
    return orderRepository.findById(id)
      .orElse(Order.builder().build());
  }

  public Order save(Member member, List<Product> products) {
    final Order order = Order.builder()
      .member(member)
      .build();

    products.stream()
        .forEach(product -> order.addProduct(product));
    return orderRepository.save(order);
  }
}

package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.entity.Product;
import com.bbubbush.springplayground.enums.Category;
import com.bbubbush.springplayground.service.MemberService;
import com.bbubbush.springplayground.service.OrderService;
import com.bbubbush.springplayground.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(3)
public class OrderAppRunner implements CommandLineRunner {
  private final MemberService memberService;
  private final ProductService productService;
  private final OrderService orderService;
  @Override
  public void run(String... args) throws Exception {
    final List<Member> members = memberService.findAll();
    final List<Product> products = productService.findAll();

    members.forEach(member -> {
      products.forEach(product -> {
        orderService.save(member, products);
      });
    });

  }
}

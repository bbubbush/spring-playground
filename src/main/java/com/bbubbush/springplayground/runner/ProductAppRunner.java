package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.enums.Category;
import com.bbubbush.springplayground.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductAppRunner implements CommandLineRunner {
  private final ProductService productService;
  @Override
  public void run(String... args) throws Exception {
    productService.save("모카빵", Category.BREAD);
    productService.save("피자빵", Category.BREAD);
    productService.save("아이스아메리카노", Category.COFFEE);
    productService.save("아이스카페라떼", Category.COFFEE);
    productService.save("더블초코칩쿠키", Category.COOKIE);
    productService.save("마카다미아쿠", Category.COOKIE);
  }
}

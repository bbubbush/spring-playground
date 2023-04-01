package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(1)
public class MemberAppRunner implements CommandLineRunner {
  private final MemberService memberService;
  @Override
  public void run(String... args) throws Exception {
    log.debug("Hello111");
    IntStream.range(0, 5)
      .forEach(i -> memberService.save("bbubbush" + i));
  }
}

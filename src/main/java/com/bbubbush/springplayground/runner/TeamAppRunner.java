package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(1)
public class TeamAppRunner implements CommandLineRunner {
  private final TeamService teamService;
  @Override
  public void run(String... args) {
    teamService.save("Team_A");
    teamService.save("Team_B");
    teamService.save("Team_C");
    teamService.save("Team_D");
    teamService.save("Team_E");
  }
}

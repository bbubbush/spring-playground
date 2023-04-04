package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.entity.Team;
import com.bbubbush.springplayground.enums.Position;
import com.bbubbush.springplayground.service.MemberService;
import com.bbubbush.springplayground.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(2)
@Transactional
public class MemberAppRunner implements CommandLineRunner {
  private final MemberService memberService;
  private final TeamService teamService;
  @Override
  public void run(String... args) {
    final List<Team> allOfTeam = teamService.findAll();

    allOfTeam.forEach(team -> {
        Member createMember = memberService.save("bbubbush", Position.BACKEND);
        createMember.addTeam(team);
      });
  }
}

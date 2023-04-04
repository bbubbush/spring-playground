package com.bbubbush.springplayground.service;

import com.bbubbush.springplayground.entity.Team;
import com.bbubbush.springplayground.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {
  private final TeamRepository teamRepository;
  public List<Team> findAll() {
    return teamRepository.findAll();
  }

  public Team findTeamById(Long id) {
    return teamRepository.findById(id)
      .orElse(Team.builder().build());
  }

  public Team save(String name) {
    return teamRepository.save(
      Team.builder()
        .name(name)
        .build());
  }
}

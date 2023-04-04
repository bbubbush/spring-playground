package com.bbubbush.springplayground.dto.res;

import com.bbubbush.springplayground.entity.Team;
import lombok.Getter;

@Getter
public class TeamResDto {
  private final Long id;
  private final String name;

  public TeamResDto(Team team) {
    this.id = team.getId();
    this.name = team.getName();
  }
}

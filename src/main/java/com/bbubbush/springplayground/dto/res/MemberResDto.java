package com.bbubbush.springplayground.dto.res;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.enums.Position;
import lombok.Getter;

@Getter
public class MemberResDto {
  private final Long id;
  private final String name;
  private final Position position;
  private final TeamResDto team;

  public MemberResDto(Member member) {
    this.id = member.getId();
    this.name = member.getName();
    this.position = member.getPosition();
    this.team = new TeamResDto(member.getTeam());
  }
}

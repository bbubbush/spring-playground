package com.bbubbush.springplayground.entity;

import com.bbubbush.springplayground.enums.Position;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  private String name;
  @Enumerated(EnumType.STRING)
  private Position position;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  @Builder
  public Member(String name, Position position, Team team) {
    this.name = name;
    this.position = position;
    this.team = team;
  }

//  public MemberResDto toMemberResDto() {
//     return MemberResDto.builder()
//       .id(this.id)
//       .name(this.name)
//       .position(this.position)
//       .team(this.team)
//       .build();
//  }

  public void addTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }
}

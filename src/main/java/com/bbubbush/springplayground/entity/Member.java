package com.bbubbush.springplayground.entity;

import com.bbubbush.springplayground.dto.res.MemberResDto;
import com.bbubbush.springplayground.enums.MemberGrade;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  private String name;
  @Enumerated(EnumType.STRING)
  private MemberGrade grade;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();

  @Builder
  public Member(String name) {
    this.name = name;
    this.grade = MemberGrade.NONE;
  }

  public MemberResDto toMemberResDto() {
     return MemberResDto.builder()
       .id(this.id)
       .name(this.name)
       .grade(this.grade)
       .build();
  }
}

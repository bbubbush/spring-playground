package com.bbubbush.springplayground.dto.res;

import com.bbubbush.springplayground.enums.MemberGrade;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResDto {
  private Long id;
  private String name;
  private MemberGrade grade;
}

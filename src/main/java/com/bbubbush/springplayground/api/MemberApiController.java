package com.bbubbush.springplayground.api;

import com.bbubbush.springplayground.dto.res.MemberResDto;
import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberApiController {
  private final MemberService memberService;
  @GetMapping("/list")
  public List<MemberResDto> findAll() {
    return memberService.findAll()
      .stream()
      .map(Member::toMemberResDto)
      .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public MemberResDto findMemberById(@PathVariable Long id) {
    return memberService.findMemberById(id)
      .toMemberResDto();
  }


}

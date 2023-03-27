package com.bbubbush.springplayground.service;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
  private final MemberRepository memberRepository;
  public Member findMemberById(Long id) {
    return memberRepository.findById(id)
      .orElse(Member.builder().build());
  }

  public Member save(String name) {
    return memberRepository.save(
      Member.builder()
        .name(name)
        .build());
  }
}

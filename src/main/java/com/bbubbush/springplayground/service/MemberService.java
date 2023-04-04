package com.bbubbush.springplayground.service;

import com.bbubbush.springplayground.entity.Member;
import com.bbubbush.springplayground.enums.Position;
import com.bbubbush.springplayground.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
  private final MemberRepository memberRepository;
  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  public Member findMemberById(Long id) {
    return memberRepository.findById(id)
      .orElse(Member.builder().build());
  }

  public Member save(String name, Position position) {
    return memberRepository.save(
      Member.builder()
        .name(name)
        .position(position)
        .build());
  }
}

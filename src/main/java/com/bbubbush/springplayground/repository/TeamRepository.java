package com.bbubbush.springplayground.repository;

import com.bbubbush.springplayground.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}

package com.lajosdanielsavoly.stackoverflowclone.repositories;

import com.lajosdanielsavoly.stackoverflowclone.entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Long> {
}

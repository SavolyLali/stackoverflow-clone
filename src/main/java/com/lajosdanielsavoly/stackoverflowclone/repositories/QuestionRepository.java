package com.lajosdanielsavoly.stackoverflowclone.repositories;

import com.lajosdanielsavoly.stackoverflowclone.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
}

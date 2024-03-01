package com.lajosdanielsavoly.stackoverflowclone.services.questions;


import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);
}

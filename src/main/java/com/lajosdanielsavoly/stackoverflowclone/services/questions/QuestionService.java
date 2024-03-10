package com.lajosdanielsavoly.stackoverflowclone.services.questions;


import com.lajosdanielsavoly.stackoverflowclone.dtos.AllQuestionResponseDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);

    AllQuestionResponseDto getAllQuestions(int pageNumber);
}

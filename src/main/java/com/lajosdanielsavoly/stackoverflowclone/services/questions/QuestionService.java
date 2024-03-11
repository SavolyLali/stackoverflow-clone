package com.lajosdanielsavoly.stackoverflowclone.services.questions;


import com.lajosdanielsavoly.stackoverflowclone.dtos.AllQuestionResponseDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.SingleQuestionDto;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);

    AllQuestionResponseDto getAllQuestions(int pageNumber);

    SingleQuestionDto getQuestionById(Long questionId);
}

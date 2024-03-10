package com.lajosdanielsavoly.stackoverflowclone.services.answer;

import com.lajosdanielsavoly.stackoverflowclone.dtos.AnswerDto;

public interface AnswerService {
    AnswerDto postAnswer(AnswerDto answerDto);
}

package com.lajosdanielsavoly.stackoverflowclone.services.answer;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerService answerService;

    public AnswerServiceImpl(AnswerService answerService) {
        this.answerService = answerService;
    }
}

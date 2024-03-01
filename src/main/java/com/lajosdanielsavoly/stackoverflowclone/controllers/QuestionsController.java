package com.lajosdanielsavoly.stackoverflowclone.controllers;

import com.lajosdanielsavoly.stackoverflowclone.services.questions.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {

    private final QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

}

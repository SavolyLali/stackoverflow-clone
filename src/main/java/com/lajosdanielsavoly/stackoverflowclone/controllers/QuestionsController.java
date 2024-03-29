package com.lajosdanielsavoly.stackoverflowclone.controllers;

import com.lajosdanielsavoly.stackoverflowclone.dtos.AllQuestionResponseDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.SingleQuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.services.questions.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuestionsController {

    private final QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public ResponseEntity<?> postQuestion(@RequestBody QuestionDto questionDto) {
        QuestionDto createdQuestionDto = questionService.addQuestion(questionDto);
        if (createdQuestionDto == null) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionDto);
    }

    @GetMapping("/questions/{pageNumber}")
    public ResponseEntity<AllQuestionResponseDto> getAllQuestions(@PathVariable int pageNumber) {
        AllQuestionResponseDto allQuestionResponseDto = questionService.getAllQuestions(pageNumber);
        return ResponseEntity.ok(allQuestionResponseDto);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long questionId) {
        SingleQuestionDto singleQuestionDto = questionService.getQuestionById(questionId);
        if (singleQuestionDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(singleQuestionDto);
    }

}

package com.lajosdanielsavoly.stackoverflowclone.services.questions;

import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.entities.Questions;
import com.lajosdanielsavoly.stackoverflowclone.entities.User;
import com.lajosdanielsavoly.stackoverflowclone.repositories.QuestionRepository;
import com.lajosdanielsavoly.stackoverflowclone.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {
        Optional<User> optionalUser = userRepository.findById(questionDto.getUserId());
        if (optionalUser.isPresent()) {
            Questions question = new Questions();
            question.setTitle(questionDto.getTitle());
            question.setBody(questionDto.getBody());
            question.setTags(questionDto.getTags());
            question.setCreatedDate(new Date());
            Questions createdQuestion = questionRepository.save(question);
            QuestionDto createdQuestionDto = new QuestionDto();
            createdQuestionDto.setId(createdQuestion.getId());
            createdQuestionDto.setTitle(createdQuestion.getTitle());
            return createdQuestionDto;
        }
        return null;
    }
}

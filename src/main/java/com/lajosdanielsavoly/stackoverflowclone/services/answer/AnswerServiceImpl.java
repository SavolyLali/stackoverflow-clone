package com.lajosdanielsavoly.stackoverflowclone.services.answer;

import com.lajosdanielsavoly.stackoverflowclone.dtos.AnswerDto;
import com.lajosdanielsavoly.stackoverflowclone.entities.Answers;
import com.lajosdanielsavoly.stackoverflowclone.entities.Questions;
import com.lajosdanielsavoly.stackoverflowclone.entities.User;
import com.lajosdanielsavoly.stackoverflowclone.repositories.AnswerRepository;
import com.lajosdanielsavoly.stackoverflowclone.repositories.QuestionRepository;
import com.lajosdanielsavoly.stackoverflowclone.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public AnswerDto postAnswer(AnswerDto answerDto) {
        Optional<User> optionalUser = userRepository.findById(answerDto.getUserId());
        Optional<Questions> optionalQuestion = questionRepository.findById(answerDto.getQuestionId());
        if (optionalUser.isPresent() && optionalQuestion.isPresent()) {
            Answers answer = new Answers();
            answer.setBody(answerDto.getBody());
            answer.setCreatedDate(new Date());
            answer.setUser(optionalUser.get());
            answer.setQuestion(optionalQuestion.get());
            Answers createdAnswers =  answerRepository.save(answer);
            AnswerDto createdAnswerDto = new AnswerDto();
            createdAnswerDto.setId(createdAnswers.getId());
            return createdAnswerDto;
        }
        return null;
    }
}

package com.lajosdanielsavoly.stackoverflowclone.services.questions;

import com.lajosdanielsavoly.stackoverflowclone.dtos.AllQuestionResponseDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.AnswerDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.dtos.SingleQuestionDto;
import com.lajosdanielsavoly.stackoverflowclone.entities.Answers;
import com.lajosdanielsavoly.stackoverflowclone.entities.Questions;
import com.lajosdanielsavoly.stackoverflowclone.entities.User;
import com.lajosdanielsavoly.stackoverflowclone.repositories.AnswerRepository;
import com.lajosdanielsavoly.stackoverflowclone.repositories.QuestionRepository;
import com.lajosdanielsavoly.stackoverflowclone.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    public static final int SEARCH_RESULT_PER_PAGE = 5;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
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
            question.setUser(optionalUser.get());
            Questions createdQuestion = questionRepository.save(question);
            QuestionDto createdQuestionDto = new QuestionDto();
            createdQuestionDto.setId(createdQuestion.getId());
            createdQuestionDto.setTitle(createdQuestion.getTitle());
            return createdQuestionDto;
        }
        return null;
    }

    @Override
    public AllQuestionResponseDto getAllQuestions(int pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, SEARCH_RESULT_PER_PAGE);
        Page<Questions> questionsPage = questionRepository.findAll(paging);
        AllQuestionResponseDto allQuestionResponseDto = new AllQuestionResponseDto();
        allQuestionResponseDto.setQuestionDtoList(questionsPage.getContent().stream().map(Questions::getQuestionDto).collect(Collectors.toList()));
        allQuestionResponseDto.setPageNumber(questionsPage.getPageable().getPageNumber());
        allQuestionResponseDto.setTotalPages(questionsPage.getTotalPages());
        return allQuestionResponseDto;
    }

    @Override
    public SingleQuestionDto getQuestionById(Long questionId) {
        Optional<Questions> optionalQuestion = questionRepository.findById(questionId);
        if (optionalQuestion.isPresent()) {
            SingleQuestionDto singleQuestionDto = new SingleQuestionDto();
            List<AnswerDto> answerDtoList = new ArrayList<>();
            singleQuestionDto.setQuestionDto(optionalQuestion.get().getQuestionDto());
            List<Answers> answerList = answerRepository.findAllByQuestionId(questionId);

            for (Answers answer : answerList) {
                AnswerDto answerDto = answer.getAnswerDto();
                answerDtoList.add(answerDto);
            }
            singleQuestionDto.setAnswerDtoList(answerDtoList);
            return singleQuestionDto;
        }
        return null;
    }
}

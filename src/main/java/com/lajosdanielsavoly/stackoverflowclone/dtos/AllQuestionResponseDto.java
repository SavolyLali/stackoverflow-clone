package com.lajosdanielsavoly.stackoverflowclone.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AllQuestionResponseDto {

    private List<QuestionDto> questionDtoList;
    private Integer totalPages;
    private Integer pageNumber;
}

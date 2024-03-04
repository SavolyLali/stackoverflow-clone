package com.lajosdanielsavoly.stackoverflowclone.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private Long id;
    private String title;
    private String body;
    private List<String> tags;
    private Long userId;
    private String username;

}

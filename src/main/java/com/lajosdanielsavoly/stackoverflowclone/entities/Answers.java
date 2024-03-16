package com.lajosdanielsavoly.stackoverflowclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lajosdanielsavoly.stackoverflowclone.dtos.AnswerDto;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "body", length = 512)
    private String body;

    private Date createdDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Questions question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public AnswerDto getAnswerDto() {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(this.id);
        answerDto.setBody(this.body);
        answerDto.setCreatedDate(this.createdDate);
        answerDto.setUserId(this.user.getId());
        answerDto.setUsername(this.user.getName());
        answerDto.setQuestionId(this.question.getId());
        return answerDto;
    }
}
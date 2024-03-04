package com.lajosdanielsavoly.stackoverflowclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lajosdanielsavoly.stackoverflowclone.dtos.QuestionDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Lob
    @Column(name = "body", length = 512)
    private String body;
    private Date createdDate;

    @ElementCollection(targetClass = String.class)
    private List<String> tags;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public QuestionDto getQuestionDto() {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(this.id);
        questionDto.setTitle(this.title);
        questionDto.setBody(this.body);
        questionDto.setTags(this.tags);
        questionDto.setUserId(this.user.getId());
        questionDto.setUsername(this.user.getName());
        return questionDto;
    }
}

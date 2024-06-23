package com.tttn.webthitracnghiem.dto;

import com.tttn.webthitracnghiem.model.Exam;
import com.tttn.webthitracnghiem.model.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class QuestionDto {
    private int quesId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int ans;
    private int chose;
    private int level;
    private Set<Exam> exams;
    private Subject subject;
}

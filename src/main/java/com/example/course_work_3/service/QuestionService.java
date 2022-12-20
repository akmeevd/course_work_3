package com.example.course_work_3.service;

import com.example.course_work_3.model.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Set<Question> addQuestion(String question, String answer);
    public Set<Question> addQuestion(Question question);

    public Set<Question> removeQuestion(String question, String answer);

    public Set<Question> getAllQuestions();

    public Question getRandomQuestion();
}

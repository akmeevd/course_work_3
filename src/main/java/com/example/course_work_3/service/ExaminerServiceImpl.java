package com.example.course_work_3.service;

import com.example.course_work_3.MoreExpectedQuestionsThenTheyAreException;
import com.example.course_work_3.model.Question;
import com.example.course_work_3.service.ExaminerService;
import com.example.course_work_3.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Set<Question> getQuestions(int amount) {
        try {
            if (amount > questionService.getAllQuestions().size()) {
                throw new MoreExpectedQuestionsThenTheyAreException(String.valueOf(HttpStatus.BAD_REQUEST));
            }
        } catch (MoreExpectedQuestionsThenTheyAreException e) {
            System.out.println(e.getMessage());
            return null;
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() != amount) {
            Question question = questionService.getRandomQuestion();
            questions.add(question);
        }
        return questions;
    }
}

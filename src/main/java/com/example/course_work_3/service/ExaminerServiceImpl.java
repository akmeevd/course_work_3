package com.example.course_work_3.service;

import com.example.course_work_3.MoreExpectedQuestionsThenTheyAreException;
import com.example.course_work_3.model.JavaQuestionRepository;
import com.example.course_work_3.model.MathQuestionRepository;
import com.example.course_work_3.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Set<Question> getQuestions(int amount) throws MoreExpectedQuestionsThenTheyAreException {
        if (amount > questionService.getAllQuestions().size()) {
            throw new MoreExpectedQuestionsThenTheyAreException(String.valueOf(HttpStatus.BAD_REQUEST));
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() != amount) {
            Question question = questionService.getRandomQuestion();
            questions.add(question);
        }
        return questions;
    }

}

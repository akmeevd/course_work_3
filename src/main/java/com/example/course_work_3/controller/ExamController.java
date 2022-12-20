package com.example.course_work_3.controller;

import com.example.course_work_3.MoreExpectedQuestionsThenTheyAreException;
import com.example.course_work_3.service.ExaminerServiceImpl;
import com.example.course_work_3.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Set<Question> getRandomQuestions(@RequestParam int amount) throws MoreExpectedQuestionsThenTheyAreException {
        return examinerService.getQuestions(amount);
    }
}

package com.example.course_work_3.controller;

import com.example.course_work_3.service.QuestionService;
import com.example.course_work_3.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController (@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Set<Question> addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Set<Question> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping()
    public Set<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

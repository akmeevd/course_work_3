package com.example.course_work_3;

import com.example.course_work_3.model.Question;
import com.example.course_work_3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        Set<Question> questions = new HashSet<>(Set.of());
        javaQuestionService = new JavaQuestionService(questions);
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        javaQuestionService.addQuestion(question1.getQuestion(), question1.getAnswer());
        javaQuestionService.addQuestion(question2.getQuestion(), question2.getAnswer());
    }

    @Test
    public void addQuestion() {
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1,question2));
    }

    @Test
    public void removeQuestion() {
        Question question1 = new Question("1", "1");
        javaQuestionService.removeQuestion("2", "2");
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1));
    }

    @Test
    public void getAllQuestions() {
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1,question2));
    }

    @Test
    public void getRandomQuestion() {
        Assertions.assertTrue(javaQuestionService.getAllQuestions().contains(javaQuestionService.getRandomQuestion()));
    }



}

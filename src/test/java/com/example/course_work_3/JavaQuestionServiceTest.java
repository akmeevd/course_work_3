package com.example.course_work_3;

import com.example.course_work_3.model.Question;
import com.example.course_work_3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {

    private Question question1;

    private Question question2;

    private Question question3;

    private Set<Question> questions;

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        question1 = new Question("1", "1");
        question2 = new Question("2", "2");
        question3 = new Question("3", "3");
        questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        javaQuestionService = new JavaQuestionService(questions);
    }

    @Test
    public void addQuestion1() {
        javaQuestionService.addQuestion("3", "3");
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1,question2,question3));
    }

    @Test
    public void addQuestion2() {
        javaQuestionService.addQuestion(question3);
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1,question2, question3));
    }

    @Test
    public void removeQuestion() {
        javaQuestionService.removeQuestion("2", "2");
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1));
    }

    @Test
    public void getAllQuestions() {
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), Set.of(question1,question2));
    }

    @Test
    public void getRandomQuestion() {
        Assertions.assertTrue(javaQuestionService.getAllQuestions().contains(javaQuestionService.getRandomQuestion()));
    }
}

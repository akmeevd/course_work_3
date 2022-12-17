package com.example.course_work_3;

import com.example.course_work_3.model.Question;
import com.example.course_work_3.service.ExaminerServiceImpl;
import com.example.course_work_3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService javaQuestionService;


    @BeforeEach
    public void setUp() {
        Question question1 = new Question("1", "1");
        Question question2 = new Question("2", "2");
        Mockito.when(javaQuestionService.getAllQuestions()).thenReturn(Set.of(question1,question2));
        Mockito.when(examinerService.getQuestions(anyInt())).thenReturn(Set.of(question1, question2));
    }

    @Test
    public void getRandomQuestions() {
        Set<Question> questions = javaQuestionService.getAllQuestions();
        Assertions.assertEquals(questions, examinerService.getQuestions(anyInt()));
    }

}

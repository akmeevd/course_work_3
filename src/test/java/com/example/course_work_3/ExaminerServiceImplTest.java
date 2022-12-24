package com.example.course_work_3;

import com.example.course_work_3.model.Question;
import com.example.course_work_3.service.ExaminerServiceImpl;
import com.example.course_work_3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private Question question1;

    private Question question2;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService javaQuestionService;


    @BeforeEach
    public void setUp() {
        question1 = new Question("1", "1");
        question2 = new Question("2", "2");
        Mockito.when(javaQuestionService.getAllQuestions()).thenReturn(Set.of(question1, question2));
    }

    @Test
    public void getRandomQuestions() throws MoreExpectedQuestionsThenTheyAreException {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question1, question2);
        Assertions.assertEquals(javaQuestionService.getAllQuestions(), examinerService.getQuestions(2));
    }

    @Test
    public void moreExpectedQuestionsThenTheyAreException() {
        Assertions.assertThrows(MoreExpectedQuestionsThenTheyAreException.class,
                () -> examinerService.getQuestions(3));
    }

}

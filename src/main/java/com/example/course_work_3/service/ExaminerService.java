package com.example.course_work_3.service;

import com.example.course_work_3.MoreExpectedQuestionsThenTheyAreException;
import com.example.course_work_3.model.Question;
import java.util.Set;


public interface ExaminerService {

    public Set<Question> getQuestions(int amount) throws MoreExpectedQuestionsThenTheyAreException;
}

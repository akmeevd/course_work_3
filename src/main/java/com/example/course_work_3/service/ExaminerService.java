package com.example.course_work_3.service;

import com.example.course_work_3.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface ExaminerService {

    public Set<Question> getQuestions(int amount);
}

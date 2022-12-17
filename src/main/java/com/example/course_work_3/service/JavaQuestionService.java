package com.example.course_work_3.service;


import com.example.course_work_3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;


@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }
    @Override
    public Question getRandomQuestion() {
        int counter = 0;
        int random = new Random().nextInt(questions.size());
        for (Question question : questions) {
            if (counter == random) {
                return question;
            }
            counter++;
        }
        return null;
    }
    @Override
    public Set<Question> addQuestion(String question, String answer) {
        questions.add(new Question(question,answer));
        return questions;
    }
    @Override
    public Set<Question> removeQuestion(String question, String answer) {
        questions.removeIf(question1 -> question1.getQuestion().equals(question) && question1.getAnswer().equals(answer));
        return questions;
    }
    @Override
    public Set<Question> getAllQuestions() {
        return questions;
    }
}

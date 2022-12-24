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
        Object[] questionsArray = questions.toArray();
        int random = new Random().nextInt(questions.size());
        return (Question) questionsArray[random];

    }

    @Override
    public Set<Question> addQuestion(String question, String answer) {
        questions.add(new Question(question,answer));
        return questions;
    }

    @Override
    public Set<Question> addQuestion(Question question) {
        questions.add(question);
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

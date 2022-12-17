package com.example.course_work_3;

public class MoreExpectedQuestionsThenTheyAreException extends Exception {
    public MoreExpectedQuestionsThenTheyAreException() {
    }

    public MoreExpectedQuestionsThenTheyAreException(String message) {
        super(message);
    }

    public MoreExpectedQuestionsThenTheyAreException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoreExpectedQuestionsThenTheyAreException(Throwable cause) {
        super(cause);
    }

    public MoreExpectedQuestionsThenTheyAreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

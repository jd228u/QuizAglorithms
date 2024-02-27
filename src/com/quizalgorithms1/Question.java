package com.quizalgorithms1;

import java.util.List;

public class Question {
    private String text;
    private List<String> options;
    private int answerIndex; // Index of the correct answer in the options list

    public Question(String text, List<String> options, int answerIndex) {
        this.text = text;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean checkAnswer(int userAnswerIndex) {
        return userAnswerIndex == answerIndex;
    }
}

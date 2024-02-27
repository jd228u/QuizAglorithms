package com.quizalgorithms1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private JFrame frame;
    private JPanel panel;
    private ButtonGroup optionsGroup;
    private JLabel questionLabel;
    private List<JRadioButton> optionButtons;
    private JButton submitButton;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;

        // Set up the frame
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Set up the panel and layout
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Set up the question label
        questionLabel = new JLabel("Question text");
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(questionLabel);

        // Set up the options
        optionsGroup = new ButtonGroup();
        optionButtons = new ArrayList<>();

        // Set up the submit button
        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestionIndex < questions.size()) {
                    Question currentQuestion = questions.get(currentQuestionIndex);
                    int selectedIndex = getSelectedOptionIndex();
                    if (selectedIndex != -1 && currentQuestion.checkAnswer(selectedIndex)) {
                        score++;
                    }
                    currentQuestionIndex++;
                    if (currentQuestionIndex >= questions.size()) {
                        endQuiz();
                    } else {
                        displayQuestion(currentQuestionIndex);
                    }
                }
            }
        });
    }

    private int getSelectedOptionIndex() {
        for (int i = 0; i < optionButtons.size(); i++) {
            if (optionButtons.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    private void displayQuestion(int questionIndex) {
        Question question = questions.get(questionIndex);
        questionLabel.setText(question.getText());
        optionsGroup.clearSelection();

        // Remove the old radio buttons
        for (JRadioButton optionButton : optionButtons) {
            panel.remove(optionButton);
            optionsGroup.remove(optionButton);
        }
        optionButtons.clear();

        // Add new radio buttons for the current question
        for (String option : question.getOptions()) {
            JRadioButton optionButton = new JRadioButton(option);
            optionButtons.add(optionButton);
            optionsGroup.add(optionButton);
            panel.add(optionButton);
        }

        // Refresh the panel to show new radio buttons
        panel.revalidate();
        panel.repaint();
    }


    private void endQuiz() {
        JOptionPane.showMessageDialog(frame,
                "Quiz finished! Your score: " + score + "/" + questions.size(),
                "Quiz Completed",
                JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        if (questions.size() > 0) {
            displayQuestion(0);
            panel.add(submitButton);
            frame.add(panel);
            frame.setVisible(true);
        }
    }
}

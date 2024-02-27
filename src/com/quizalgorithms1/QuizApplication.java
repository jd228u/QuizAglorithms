package com.quizalgorithms1;

import java.util.List;

public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding questions
        quiz.addQuestion(new Question(
                "A partially correct algorithm can never go into an infinite loop.",
                List.of("True", "False"),
                1 // the second option ("False") is correct.
        ));

        // Question 2
        quiz.addQuestion(new Question(
                "A solution to an undecidable problem can be partially correct.",
                List.of("True", "False"),
                1 // the second option ("False") is correct.
        ));

        // Question 3
        quiz.addQuestion(new Question(
                "Every primitive recursive function can be computed without using recursion.",
                List.of("True", "False"),
                0 // the first option ("True") is correct.
        ));

        // Question 4
        quiz.addQuestion(new Question(
                "Huffman codes must have unique prefixes, but Shannon-Fano codes do not.",
                List.of("True", "False"),
                1 // the second option ("False") is correct.
        ));

        // Question 5
        quiz.addQuestion(new Question(
                "On a mismatch, the Boyer-Moore algorithm always resumes matching from the last character in the pattern.",
                List.of("True", "False"),
                1 // the second option ("False") is correct.
        ));

        // Question 6
        quiz.addQuestion(new Question(
                "Given a string search for a specific substring P in a text T, where T is at least as long as P, Boyer-Moore string search always runs faster than Knuth-Morris-Pratt.",
                List.of("True", "False"),
                1 // the second option ("False") is correct.
        ));

        // Question 7
        quiz.addQuestion(new Question(
                "The Rabin-Karp string search utilises hashing without using any hashtable or hashmap.",
                List.of("True", "False"),
                0 // the first option ("True") is correct.
        ));

        // Question 8
        quiz.addQuestion(new Question(
                "Any language that can be described by a regular expression can also be described by a context-free grammar.",
                List.of("True", "False"),
                0 // the first option ("True") is correct.
        ));

        // Question 9
        quiz.addQuestion(new Question(
                "When 'pattern searching' with a finite state machine, the search can only ever be in one state at any given moment.",
                List.of("True", "False"),
                0 // the first option ("True") is correct.
        ));

        // Question 10
        quiz.addQuestion(new Question(
                "The principle of optimality holds for a specific problem if dynamic programming can solve that problem.",
                List.of("True", "False"),
                0 // the first option ("True") is correct.
        ));


        quiz.start();
    }
}

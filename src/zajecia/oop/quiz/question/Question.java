package zajecia.oop.quiz.question;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-25.
 */
public class Question {

    // klasa oisująca pojedyncze pytanie

    private String question;
    private int correctAnswer;
    private String[] answers;

    public Question(String question, int correctAnswer, String[] answers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    // GETTERY - tylko dla question i answers, bo correctAnswer nie chcemy pokazywac userowi

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    //zamiast tego utworzymy swoja metode, ktora odpowie userowi, czy podana przez niego odpowiedz jest prawidlowa
    public boolean chceckAnswer(int answer) {
        return this.correctAnswer == answer;
    }

    // SETTERY - nie towrzymy, zbioru pytan nie zmianiamy


    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}

package zajecia.oop.quiz;

import zajecia.oop.quiz.question.Question;
import zajecia.oop.quiz.result.Result;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-25.
 */
public class QuizInterface {

    // jest to klasa, ktora zawiera poszczegolne klocki budujace interfejs dla uzytkownika

    private Scanner scanner;

    public QuizInterface() {
        this.scanner = new Scanner(System.in);
    }

    public int menu() {
        System.out.println("1. Start");
        System.out.println("2. Wyniki");
        System.out.println("0. Koniec");

        int tmpAnswer = scanner.nextInt();
        this.scanner.nextLine();

        return tmpAnswer;
    }

    public String insertName() {
        System.out.print("Insert your name: ");
        return this.scanner.nextLine();
    }

    public void beforeStart() {
        System.out.println("Press enter to start");
        this.scanner.nextLine(); //czekamy aż ktoś coś wstawi
    }

    public boolean showQuestion(Question question) {
        //wyswietlam pytanie
        System.out.println(question.getQuestion());

        //wyswietlam odpowiedzi (najpierw do zmiennej pomocniczej zapisuje wszystkie warianty odpowiedzi mojego pytania)
        String[] possibleAnswers = question.getAnswers();
        for (int i = 0; i < possibleAnswers.length; i++) {
            System.out.println((i+1) + ". " + possibleAnswers[i]);
        }

        //pobieram odpowiedz od usera
        int answerFromUser = this.scanner.nextInt();
        scanner.nextLine(); //ma byc i juz :)

        //sprawdzam odp usera i zwracam true/false
        return question.chceckAnswer(answerFromUser - 1);
    }

    public void correctAnswer() {
        System.out.println("Correct answer.");
        this.scanner.nextLine();
    }

    public void incorrectAnswer() {
        System.out.println("Incorrect answer.");
        this.scanner.nextLine();
    }

    public void showResult(String name, int result) {
        System.out.println("Congratulations " + name + "! You finished game with score: " + result + ".");
    }

    //wyswietla tablice wynikow, jako argument przyjmuje tablice elementow klasy Result
    public void showResults(Result[] results) {
        System.out.println("Hall of fame:");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i+1) + ". " + results[i].getPlayerName() + "\t" + results[i].getResult());
        }
        scanner.nextLine(); //po to, zeby konsola sie na chwile zatrzymala
    }

    //wyswietla n pierwszych wynikow
    public void showTopResults(Result[] topResults) {
        System.out.println("Hall of fame:");
        for (int i = 0; i < topResults.length; i++) {
            System.out.print((i+1) + ". ");
            if (topResults[i] != null) { //wyswietlam element tylko jesli nie jest pusty
                System.out.print(topResults[i].getPlayerName() + "\t" + topResults[i].getResult());
            }
            System.out.println();
        }
    }

    public void afterGameEnded() {
        System.out.println("Game ended!");
    }

}

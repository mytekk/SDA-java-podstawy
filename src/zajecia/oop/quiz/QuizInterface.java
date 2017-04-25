package zajecia.oop.quiz;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-25.
 */
public class QuizInterface {

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

}

package zajecia.oop.quiz.question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by RENT on 2017-04-27.
 */
public class FileQuestionsRepository implements QuestionsRepository {

    // klasa do przechowywania pytań w pliku oraz odczytywania pytań z pliku
    // analogiczna do MockQuestionRepository

    private String pathToFile; ///sciezka do pliku z pytaniami
    private File fileWithResults; //plik z pytaniami

    public FileQuestionsRepository(String pathToFile) {
        this.pathToFile = pathToFile;
        this.fileWithResults = new File(pathToFile);  //inicjalizacja pliku z pytaniami przy użyciu ścieżki podanej w argumencie
    }

    public int getSize() throws FileNotFoundException {
        //zliczy liczbę pytań z pliku
        Scanner scanner = new Scanner(fileWithResults);
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            scanner.nextLine();
        }
        return counter/6; //bo każde pytanie zajmuje 6 linii w pliku
    }

    @Override
    public Question[] getQuestions() {
        Question[] questions = null; //tutaj definiuje i dale nulla na poczatek, zeby zapewnic widocznosc w bloku try-catch i ponizej niego
        try {
            Scanner scanner = new Scanner(fileWithResults);
            questions = new Question[getSize()];
            int index = 0;

            while (scanner.hasNextLine()) {
                //pierwsza linia z sześciu to treść pytania
                String questionText = scanner.nextLine();
                //pobrać odpowiedzi
                String[] answers = new String[4];
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = scanner.nextLine();
                }
                //pobrac poprawna odpowiedz
                int correctAnswer = scanner.nextInt();
                scanner.nextLine(); //bo nextInt nie przejdzie do nowejlinii i w efekcie bedzie problem przy kolejnej iteracji
                                    //czyli pobieraniu kolejnego pytania (kolejnych 6 linii)

                //tworze nowy obiekt typu Questions i zapisuje go do tablicy wynikowej pod odpowiednim indeksem
                questions[index] = map(questionText, answers, correctAnswer);

                //podbicie indexu
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public Question map(String questionsText, String[] answers, int correctAnswer) {
        //z trzech rzeczy komponuje obiekt typy Question
        return new Question(questionsText, correctAnswer, answers);
    }

}

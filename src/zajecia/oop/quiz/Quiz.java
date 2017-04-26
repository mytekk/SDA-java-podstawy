package zajecia.oop.quiz;

import zajecia.oop.quiz.question.MockQuestionRepository;
import zajecia.oop.quiz.question.Question;
import zajecia.oop.quiz.result.FileResultsRepository;
import zajecia.oop.quiz.result.MockResultRepository;
import zajecia.oop.quiz.result.Result;

/**
 * Created by RENT on 2017-04-25.
 */
public class Quiz {

    // glowna klasa aplikacji

    public static void main(String[] args) {

        // tworze obiekt klasy mock - czyli tworze naszego dostawce pytań:)
        MockQuestionRepository questionRepository = new MockQuestionRepository();

        // tworze obiekt klasy file results - czyli tworze naszego dostawce fakeowych wynikow z pliku
        FileResultsRepository resultRepository = new FileResultsRepository("C:\\Users\\RENT\\IdeaProjects\\SDA-java-podstawy\\results.txt");

        //tworze interfejs
        QuizInterface quizInterface = new QuizInterface();

        boolean gameFlag = true;
        while (gameFlag) {

            //wyswietlam menu i prosze usera o wybor pola
            int decision = quizInterface.menu();

            switch (decision) {

                case 1:

                    //imie usera
                    String playerName = quizInterface.insertName();

                    // chwila oddechu dla usera
                    quizInterface.beforeStart();

                    //do zmiennej questions (będacej tablicą obiektów klasy Question) ładuję wszystkie pytania z repozytorium wszystkich pytań
                    Question[] questions = questionRepository.getQuestions();

                    // licznik poprawnych odpowiedzi usera
                    int correctAnswerCounter = 0;

                    //wyswietlam po kolei wszystkie pytania
                    for (int i = 0; i < questions.length; i++) {
                        boolean result = quizInterface.showQuestion(questions[i]); //ta metoda zwraca tez odp usera!
                        //po wyswietleniu odpowiedzi sprawdzam wybor usera
                        if (result) {
                            quizInterface.correctAnswer();
                            correctAnswerCounter++;
                        } else {
                            quizInterface.incorrectAnswer();
                        }
                    }

                    //buduje nowy wynik
                    Result newResult = new Result(playerName, correctAnswerCounter);

                    //wyswietlenie wyniku
                    quizInterface.showResult(newResult);

                    //zapisanie wyniku do result repository
                    resultRepository.add(newResult);

                    break;

                case 2:
                    // od dostawcy fake'owych wynikow pobieram te wyniki i wyswietlam je
                    // quizInterface.showResults(resultRepository.getAllResult());
                    quizInterface.showTopResults(resultRepository.getTopResults(10));

                    break;

                case 0:
                    gameFlag = false;
                    break;

                default:
                    System.out.println("Wrong decision!");
                }

        }//while

        //koniec gry
        quizInterface.afterGameEnded();


    }//main

}

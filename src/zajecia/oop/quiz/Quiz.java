package zajecia.oop.quiz;

/**
 * Created by RENT on 2017-04-25.
 */
public class Quiz {

    public static void main(String[] args) {

        // tworze obiekt klasy mock - czyli tworze naszego dostawce pytań:)
        MockQuestionRepository questionRepository = new MockQuestionRepository();

        //tworze interfejs
        QuizInterface quizInterface = new QuizInterface();

        //wyswietlam menu i prosze usera o wybor pola
        int decision = quizInterface.menu();

        if (decision == 1) {

            //imie usera
            String playerName = quizInterface.insertName();

            // chwila oddechu dla usera
            quizInterface.beforeStart();

            //do zmiennej questions (będacej tablicą obiektów klasy Question) ładuję wszystkie pytania z repozytorium
            Question[] questions = questionRepository.getQuestions();

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

            //wyswietlenie wyniku
            quizInterface.showResult(playerName, correctAnswerCounter);

        } else if (decision == 2) {
            System.out.println("Not yet supported!");
        } else {
            System.out.println("End of game.");
        }


    }

}

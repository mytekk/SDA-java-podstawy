package zajecia.oop.quiz.result;

import zajecia.oop.quiz.question.FileQuestionsRepository;
import zajecia.oop.quiz.question.Question;
import zajecia.oop.quiz.question.QuestionsRepository;

/**
 * Created by RENT on 2017-04-26.
 */
public class Test {
    public static void main(String[] args) {
        //utworzenie obieku klasy FileResultsRepository z zadanym plikiem
//        FileResultsRepository repository = new FileResultsRepository("C:\\Users\\RENT\\IdeaProjects\\SDA-java-podstawy\\results.txt");

        //test odczytu
//        Result[] allResults = repository.getAllResults();

        //test zapisu
//        repository.add(new Result("Agnieszka", 2));

        //test odczytu
//        Result[] allResults2 = repository.getAllResults();

        //test odczytu topN resultow
//        Result[] topResults = repository.getTopResults(15);


        QuestionsRepository questionsRepository = new FileQuestionsRepository("C:\\Users\\RENT\\IdeaProjects\\SDA-java-podstawy\\quiz.txt");
        Question[] tmpQuestions = questionsRepository.getQuestions();

    }
}

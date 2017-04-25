package zajecia.oop.quiz;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-25.
 */
public class MockQuestionRepository {

    // repozytorium pytań do quizu
    public Question[] getQuestions() {
        Question[] questions = new Question[3];

        String[] answers0 = {"43", "22", "55", "23"};
        questions[0] = new Question("Ile lat ma prezydent?", 2, answers0);
        String[] answers1 = {"43", "4", "55", "23"};
        questions[1] = new Question("Ile jest 2*2?", 1, answers1);
        String[] answers2 = {"Lublin", "Warszawa", "Krakow", "Poznan"};
        questions[2] = new Question("Stolica Wielkopolski?", 3, answers2);

        return questions;
    }

}

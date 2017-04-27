package zajecia.oop.quiz.result;

/**
 * Created by RENT on 2017-04-27.
 */
public interface ResultsRepository {
    //public jest zbedne, wszystkie metody w klasach implementujacych interfejs muszą i tak byc public

    Result[] getAllResults();

    Result[] getTopResults(int n);

    void add(Result result);
}

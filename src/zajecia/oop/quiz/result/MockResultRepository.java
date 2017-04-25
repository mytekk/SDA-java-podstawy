package zajecia.oop.quiz.result;

/**
 * Created by RENT on 2017-04-25.
 */
public class MockResultRepository {

    // ta klasa zawierac bedzie tablice obiektow klasy Result, czyli jakies fake'owe wyniki :)

    private Result[] results;

    public MockResultRepository() {
        this.results = new Result[2];
        this.results[0] = new Result("Andrzej", 3);
        this.results[1] = new Result("Jan", 2);
    }

    public Result[] getAllResult() {
        return results;
    }

    public Result[] getTopResults(int n) {
        //zwraca n najlepszych wynikow
        return null;
    }

}

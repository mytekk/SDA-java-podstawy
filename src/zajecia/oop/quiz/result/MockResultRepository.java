package zajecia.oop.quiz.result;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-25.
 */
public class MockResultRepository implements ResultsRepository {

    // ta klasa zawierac bedzie tablice obiektow klasy Result, czyli jakies fake'owe wyniki :)

    private Result[] results;
    private int resultsCounter;

    public MockResultRepository() {
        this.results = new Result[100]; //duza przestrzen na resulty
        this.resultsCounter = 0;

        //dodaje jakies elementy za pomoca nowej metody add
        //przynajmniej nie musze zawracac sobie glowy podbijaniem resultsCounter
        add(new Result("Andrzej", 3));
        add(new Result("Jan", 2));
        add(new Result("Hubert", 0));
        add(new Result("Ignacy", 0));
    }

    public Result[] getAllResults() {
        Result[] resultsToReturn = new Result[resultsCounter];
        for (int i = 0; i < this.resultsCounter; i++) {
            resultsToReturn[i] = this.results[i];
        }
        return resultsToReturn;
    }

    public Result[] getTopResults(int n) {
        //zwraca n pierwszych wynikow
        Result[] resultsToReturn = new Result[n];
        int loopSize = (n < resultsCounter) ? n : resultsCounter; //jesli podam n wieksze od results.len, to wtedy zeby nie
        // wyjsc poza zakres tablica results, zwracam wszystkie elementy z results i nic wiecej
        for (int i = 0; i < loopSize; i++) {
            resultsToReturn[i] = results[i];
        }
        return resultsToReturn; //w tabeli wwynikowej moga byc od pewnego momentu nulle (kiedy n bedzie wieksze od
        // faktycznejliczby zgromadzonych results (results.lenght), oprogramuję to przywyświetlaniu
    }

    public void add(Result result) {
        //dodawanie nowego result do naszego zbioru
        this.results[resultsCounter] = result; //dodaje nowy element na koncu (najdalszy oebecny element to (resultsCounter - 1)) tablicy this.results
        resultsCounter++; //dodałem, wiec zwiększam counter
    }

}

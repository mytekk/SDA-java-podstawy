package zajecia.oop.quiz.result;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-25.
 */
public class MockResultRepository {

    // ta klasa zawierac bedzie tablice obiektow klasy Result, czyli jakies fake'owe wyniki :)

    private Result[] results;

    public MockResultRepository() {
        this.results = new Result[15];
        this.results[0] = new Result("Andrzej", 3);
        this.results[1] = new Result("Jan", 2);
        this.results[2] = new Result("Hubert", 0);
        this.results[3] = new Result("Ignacy", 0);
        this.results[4] = new Result("Bartosz", 1);
        this.results[5] = new Result("Marcin", 3);
        this.results[6] = new Result("Michał", 3);
        this.results[7] = new Result("Paweł", 2);
        this.results[8] = new Result("Łukasz", 0);
        this.results[9] = new Result("Piotr", 1);
        this.results[10] = new Result("Jacek", 0);
        this.results[11] = new Result("Zygmunt", 1);
        this.results[12] = new Result("Stanisław", 3);
        this.results[13] = new Result("Antoni", 3);
        this.results[14] = new Result("Zbigniew", 2);
    }

    public Result[] getAllResult() {
        return results;
    }

    public Result[] getTopResults(int n) {
        //zwraca n najlepszych wynikow

        //najpierw sortowanie tablicy results, bede przepisywal do drugiej tablicy
        Result[] tmpResultArray = new Result[this.results.length];
        for (int i = 0; i < results.length - 1; i++) {
            Result result1 = results[i];
            Result result2 = results[i+1];
            if (result1.getResult() > result2.getResult()) {
                tmpResultArray[i] = result1;
            }
            else {
                tmpResultArray[i] = result2;
            }
        }

        //teraz by trzeba zwrocic pierwszych n-elementow tej tablicy
        //ale poki co zwracam wszystko
        return tmpResultArray;
    }

}

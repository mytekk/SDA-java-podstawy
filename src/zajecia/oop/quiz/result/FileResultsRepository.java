package zajecia.oop.quiz.result;

import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-04-26.
 */
public class FileResultsRepository {

    // klasa do przechowywania resultów w pliku oraz odczytywania resultow z pliku
    // analogiczna do MockResultRepository

    private String pathToFile; ///sciezka do pliku z wynikami
    private File fileWithResults; //plik z wynikami

    public FileResultsRepository(String pathToFile) {
        this.pathToFile = pathToFile;
        this.fileWithResults = new File(pathToFile);
    }

    public int getSize() {
        //ma zwracac ilosc resultow w pliku
        int counter = 0;
        try {
            Scanner scanner = new Scanner(fileWithResults);
            while (scanner.hasNextLine()) {
                counter++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public Result[] getAllResults() {
        //pobiera wszystkie resulty z pliku
        Result[] results = new Result[getSize()];

        try {
            Scanner scanner = new Scanner(fileWithResults);

            //czytamy z pliku
            int i = 0;
            while (scanner.hasNextLine()) {
                results[i] = mapToResult(scanner.nextLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }

    private Result mapToResult(String resultString) {
        //zamienia stringa na obiekt typu Result - ten string to linia tekstu z pliku
        //string jest postaci: imie + spacja + liczba_punktow

        String[] split = resultString.split(" "); //dziele string na tablice dzielac po spacji

        //zwracam nowy obiekt typu Result
        return new Result(split[0], Integer.valueOf(split[1])); //bo nie moge zrobic (int)"2", bo byc moze zamiast
                                                                //liczby jako drugie pole w linii w pliku bede mial
                                                                //jakis tekst - wtedy bylby problem przy rzutowaniu
    }

    public void add(Result result) {
        //zapisuje nowy result do pliku
        try (
                FileWriter fw = new FileWriter(fileWithResults, true); //to jest dodatkowy blok
                BufferedWriter bw = new BufferedWriter(fw); //zmienne tutaj zdefiniowane zostaną eleganko zamknięte
                PrintWriter out = new PrintWriter(bw) //po zakończeniu try-catch. Sam nie musze sie o to martwic.
        ) {
            //tutaj wrzucam tę logikę na której mi faktycznie zależy
            out.println(result.toString());  //toString mam w klasie Result, on elegancko opisze mi ten result, ktory chce wrzucic do pliku
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result[] getTopResults(int n) {
        //zwraca n pierwszych wynikow
        Result[] resultsToReturn = new Result[n];
        try {
            Scanner scanner = new Scanner(fileWithResults);
            int loopSize = (n < getSize()) ? n : getSize(); //jesli podam n wieksze od liczby resultow w pliku, to wtedy zeby nie
            // wyjsc poza zakres pliku, zwracam wszystkie elementy z pliku i nic wiecej (a nie n)
            for (int i = 0; i < loopSize; i++) {
                resultsToReturn[i] = mapToResult(scanner.nextLine()); //to mi zamieni stringa z pliku na obiekt typu Result i zapisze go do tablicy wynikowej
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return resultsToReturn; //w tabeli wwynikowej moga byc od pewnego momentu nulle (kiedy n bedzie wieksze od
        // faktycznejliczby zgromadzonych results (results.lenght), oprogramuję to przywyświetlaniu
    }

}

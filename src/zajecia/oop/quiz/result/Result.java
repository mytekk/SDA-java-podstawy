package zajecia.oop.quiz.result;

/**
 * Created by RENT on 2017-04-25.
 */
public class Result {

    // ta klasa zawierać bedzie pojedynczy wynik: czyli imie usera i wynik punktowy

    private String playerName;
    private int result;

    public Result(String playerName, int result) {
        this.playerName = playerName;
        this.result = result;
    }

    // GETTERY

    public String getPlayerName() {
        return playerName;
    }

    public int getResult() {
        return result;
    }
}

package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-20.
 */
public class Zajecia10_WheelAndCross {

    public static void main(String[] args) {
        char[][] gameBoard = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        int i = 0; //licznik krokow

        //gra zakonczy sie po co najwyzej 9 prawidlowych ruchach
        //graamy dopoki funkcja sprawdzajaca nie zwroci true
        while (!isGameEnded(gameBoard, i)) {
            displayBoard(gameBoard);
            int position = getPositionFromUser(gameBoard);

            //kiedy mamy juz poprawna pozycje podane przez usera, to zamieniam ja na wspolrzedne punktu, w ktorym bedzie wstawione kolko lub krzyzyk
            int[] positions = convertPosition(position);

            //w miejscewybrane przez usera wstawiam kolko lub krzyzyk
            gameBoard[positions[0]][positions[1]] = (i % 2 == 0) ? 'X' : 'O'; //kolko i krzyzyk na zmiane co drugi ruch

            i++; //zwiększam numer kroku

            System.out.println();
            System.out.println();
        }

        //koniec gry i koncowe wyswietlenie tablicy
        System.out.println("End of game!");
        displayBoard(gameBoard);
    }

    private static int getPositionFromUser(char[][] gameBoard) {
        //funkcja tak dlugo pobiera i waliduje pozycje od usera,az nie dostanie poprawnej i pustej pozycji
        Scanner scanner = new Scanner(System.in);
        boolean inputFromUserFlag = false; //flaga wyjscia z petli pytajacej usera o pozycje na gameBoard
        int position = 0; //wartosc poczatkowa odpowiedzi od usera

        while (!inputFromUserFlag) { //petla dziala dopoki flaga = false
            System.out.println("Insert sign position: ");
            position = scanner.nextInt();
            inputFromUserFlag = validatePositionFromUser(position, gameBoard); //tu jest sterownik whilea
            if (!inputFromUserFlag) { //jesli flaga jest false, to niech user poda pozycje jeszcze raz
                System.out.println("Wrong position. Insert again.");
            }
        }
        return position;
    }

    public static boolean checkRows(char[][] gameBoard) {
        //czy w ktoryms wierszu mam 3 takie same znaki
        //petla po wierszach
        int i = 0; //indeks wiersza
        boolean flag = false;
        while (i < gameBoard.length && !flag) {
            if ( (gameBoard[i][0] == gameBoard[i][1]) && (gameBoard[i][0] == gameBoard[i][2]) ) {
                flag = true;
            }
            //flag = (gameBoard[i][0] == gameBoard[i][1]) && (gameBoard[i][0] == gameBoard[i][2]);
            i++;
        }
        return flag;
    }

    public static boolean checkColumns(char[][] gameBoard) {
        //czy w ktorejs kolumnie mam 3 takie same znaki
        //petla po kolumnach
        int i = 0; //indeks kolumny
        boolean flag = false;
        while (i < gameBoard[0].length && !flag) {
            if ( (gameBoard[0][i] == gameBoard[1][i]) && (gameBoard[0][i] == gameBoard[2][i]) ) {
                flag = true;
            }
            //flag = (gameBoard[0][i] == gameBoard[1][i]) && (gameBoard[0][i] == gameBoard[2][i]);
            i++;
        }
        return flag;
    }

    public static boolean checkSecondDiagonal(char[][] gameBoard) {
        return ((gameBoard[0][2] == gameBoard[1][1]) && (gameBoard[0][2] == gameBoard[2][0]));
    }

    public static boolean checkFirstDiagonal(char[][] gameBoard) {
        return ((gameBoard[0][0] == gameBoard[1][1]) && (gameBoard[0][0] == gameBoard[2][2]));
    }

    public static boolean checkDiagonals(char[][] gameBoard) {
        //czy w ktorejs przekatnie mam 3 takie same znaki
        //elementy pierwszej przekatnej maja wspolrzedne 0-0, 1-1, 2-2, a drugiej 0-2, 1-1, 2-0
        //return ( ((gameBoard[0][0] == gameBoard[1][1]) && (gameBoard[0][0] == gameBoard[2][2]) ||
         //       ((gameBoard[0][2] == gameBoard[1][1]) && (gameBoard[0][2] == gameBoard[2][0]) ) ? true :false;
        //nie moge zrobic a==b==c, tylko (a==b) && (a==c)

        //drugi wariant
        //jesli pole 1-1 bedzie puste to od razu mozna zwrocic false
        return !isFieldEmpty(gameBoard, 1, 1) && ( checkFirstDiagonal(gameBoard) || checkSecondDiagonal(gameBoard) );
    }

    public static boolean isGameEnded(char[][] gameBoard, int gameStep) {
        return (checkRows(gameBoard) || checkColumns(gameBoard) || checkDiagonals(gameBoard)) || !(gameStep < 9) ;
        //gra konczy sie kiedy mamy gdzies 3 znaki obok siebie albo kiedy minal juz 9 krok (wtedy jest remis)
    }

    public static boolean validatePositionFromUser(int positionFromUser, char[][] gameBoard) {
        //user moze podac liczbe od 0 do 9, oraz taka, ktora juz nie jest zajeta
        int ints[] = convertPosition(positionFromUser);
        return (positionFromUser > 0 && positionFromUser < 10 &&
                isFieldEmpty(gameBoard, ints[0], ints[1]));
    }

    public static boolean isFieldEmpty(char[][] gameBoard, int i, int j) {
        //te zajete maja juz X lub O w sobie
        return !(gameBoard[i][j] == 'X' || gameBoard[i][j] == 'O');
    }

    public static int[] convertPosition(int positionFromUser) {
        //dla 5 zwroci 1:1
        //dla 4 zwroci 1:0

        int[] position = new int[2];

        position[0] = (positionFromUser - 1) / 3;
        position[1] = (positionFromUser - 1) % 3;

        return position;
    }

    public static void displayBoard(char[][] gameBoard) {
        //wyswietla macierz 3x3, ktora poczatkowo zawiera cyfry od 1 do 9, a z uplywem krokow bedzie zawierala kolka i krzyzyki
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < gameBoard[0].length - 1) System.out.print("|"); //po ostatniej kolumnie nie dodaje "|"
            }
            if (i != gameBoard.length - 1) { //po ostatnim wierszu nie dodaje poziomych kresek
                System.out.print("\n-----\n");
            }
        }
        System.out.println();
    }

}

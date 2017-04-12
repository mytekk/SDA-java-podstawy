package zajecia;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by RENT on 2017-04-12.
 */
public class Zajecia7 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int [][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//        int[][] matrix = saveToMatrixExample();
//        displayMatrix(matrix);

//        int[][] matrix = fillWithRandomNumbers(4, 4);
//        displayMatrix(matrix);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Inser number of rows: ");
//        int rows = scanner.nextInt();
//        System.out.print("Inser number of cols: ");
//        int cols = scanner.nextInt();
//        int[][] matrixFromUser = fillWithNumbersFromUser(rows, cols);
//        displayMatrix(matrixFromUser);

        System.out.println("Sum of two matrix");
        int[][] matrix1 = {{10, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 90}};
        int[][] sumOfTwoMatrix = addTwoArrays(matrix1, matrix2);
        displayMatrix(sumOfTwoMatrix);

        System.out.println("Multiply matrix by sth");
        int multiplier = 3;
        int[][] multipliedMatrix = multiplyBy(matrix1, multiplier);
        displayMatrix(multipliedMatrix);

        System.out.println("Sum of matrix elements");
        int sumMatrix = sumOfElements(matrix1);
        System.out.println("sum: " + sumMatrix);

        System.out.println("Index of highest sum:");
        int indexOfHighestSum = indexOfHighestSum(matrix1);
        System.out.println("result: " + indexOfHighestSum);

        System.out.println("Flipped matrix:");
        displayMatrix(flip(matrix1));

        System.out.println("Matrix of bigger values:");
        displayMatrix(biggerValues(matrix1, matrix2));

        System.out.println("Max value of matrix:");
        int tmp = maxValue(matrix1);
        System.out.println(tmp);

    }

    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        //iloczyn dwoch macierzy
        return null;
    }

    public static int maxValue(int[][] matrix) {
        //najwyzsza wartosc z macierzy
        int maxValue = 0;

        for (int i = 0; i < matrix.length; i++) {
                if (Zajecia4.maxFromArray(matrix[i]) > maxValue) { //sprawdzam maxymalna wartosc z calego wiersza, ktory tez jest talica
                    maxValue = Zajecia4.maxFromArray(matrix[i]);
                }
        }
        return maxValue;
    }

    public static int[][] biggerValues(int[][] matrix1, int[][] matrix2) {
        //bierzemy wieksza wartosc z jednej z dwoch macierzy i wrzucamy ja do nowej

        //tworze nowa macierz wynikowa o wymiarach pierwszej macierzy
        int[][] resultMatrix = new int[matrix1.length][matrix1[0].length];

        //przechodze przez obydwie macierze i wybieram wiekszy element
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] > matrix2[i][j]) {
                    resultMatrix[i][j] = matrix1[i][j];
                } else if (matrix1[i][j] < matrix2[i][j]) {
                    resultMatrix[i][j] = matrix2[i][j];
                } else {
                    resultMatrix[i][j] = matrix1[i][j]; //jak sa takie same to biore z pierwszej
                }
            }
        }
        return resultMatrix;


    }

    public static int[][] flip(int[][] matrix) {
        //odwracamy wiersze i kolumny, zwracamy nowa macierz
        //ten sam element ze starej macierzy znajdujesie w nowej, ale pod indeksami, ktore zostaly zamienione miejscami

        //pobieram wymiary macierzy
        int rows = matrix.length;
        int cols = matrix[0].length;

        //tworze nowa macierz o ODWROCONYCH wierszach i kolumnach
        int[][] resultMatrix = new int[cols][rows];

        //przechodze po wejsciowej macierzy i przepisuje elementy do nowej macierzy
        //ale pod zamienionymi indeksami
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static int indexOfHighestSum(int[][] matrix) {
        //zwracamy index wiersza, ktory ma najwieksza sume elementow w wierszu
        //czy mozemy uzyc jakiejsgotowej metody???

        //pobieram wymiary macierzy
        int rows = matrix.length;
        int cols = matrix[0].length;

        //definiuje dwie zmienne: najwyzsza suma i indexNajwyzszejSumy
        //int highestSum = 0;
        int indexOfHighestSum = 0; //to jest moj kandydat
        //int tmp_highestSum = 0;
        //int tmp_indexOfHighestSum = 0;

        //przechodze po wierszach i za kazdym razem sumuje caly wiersz
        //caly wiersz tez jest tablica, wiec do sumowania mge wykorzystac metode z ktorys poprzednich zajec
        //jesli obliczona suma jest wieksza od aktualnej najwyzszej sumy, to zapisuje te nowa najwyzsza sume i jej numer wiersza
        for (int i = 0; i < rows; i++) {
            //tmp_highestSum = Zajecia4.sumFromArray(matrix[i]); //matrix[i] to cały biezacy wiersz - czyli tez tablica :)
            //if (tmp_highestSum > highestSum) {
            //    highestSum = tmp_highestSum;
            //    indexOfHighestSum = i;
            //}
            //bez doatkowych zbednych zmiennych
            //w petli ide po wierszach
            //jesli suma elementow w tym wierszu <Zajecia4.sumFromArray(matrix[i])> jest wierksza od
            //sumy elementow w wierszu od mojego kandydata, czyli <Zajecia4.sumFromArray(matrix[i])>
            //to wtedy podmieniam wartosc mojego kandydata jako index biezacego wiersza
            if (Zajecia4.sumFromArray(matrix[indexOfHighestSum]) < Zajecia4.sumFromArray(matrix[i])) {
                indexOfHighestSum = i;
            }
        }

        //zwracam index wiersza z najwyzsza suma
        return indexOfHighestSum;
    }

    public static int sumOfElements(int[][] matrix) {
        //suma wszystkich elementow macierzy
        //czy mozemy uzyc jakiejs gotowej metody???

        //pobieram wymiary macierzy
        int rows = matrix.length;
        int cols = matrix[0].length;

        //mojasuma
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            sum += Zajecia4.sumFromArray(matrix[i]); //matrix[i] to cały biezacy wiersz - czyli tez tablica :)
        }
        return sum;
    }

    public static int[][] multiplyBy(int[][] matrix, int value) {
        //mnozymy kazdy element macierzy przez value, zwracamy NOWA macierz

        //pobieram wymiary pierwszej macierzy
        int rows = matrix.length;
        int cols = matrix[0].length;

        //tworze nowa macierz
        int[][] resultMatrix = new int[rows][cols];

        //sumuje elementy dwoch macierzy
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] * value;
            }
        }
        return resultMatrix;
    }

    public static int[][] addTwoArrays(int[][] matrix1, int[][] matrix2) {
        //suma dwoch macierzy,
        //zakladamy, ze obydwie sa tychsamych wymiarow, lub ta druga jest wieksza
        //macierz wynikowa ma miec wymiary pierwszej macierzy, wiec jesli druga bedzie wieksza,
        //to czesc jej elementow zostanie pominieta

        //pobieram wymiary pierwszej macierzy
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        //tworze nowa macierz
        int[][] resultMatrix = new int[rows][cols];

        //sumuje elementy dwoch macierzy
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static int[][] fillWithNumbersFromUser(int rows, int cols) {
        //tworzy tablice o zadanych wymiarach
        //wypelnia losowymi liczbami z zakresy (-15 - 15)

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Insert[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
                System.out.println();
            }
        }
        return matrix;
    }

    public static int[][] fillWithRandomNumbers(int rows, int cols) {
        //tworzy tablice o zadanych wymiarach
        //wypelnia losowymi liczbami z zakresy (-15 - 15)

        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(30) - 15;
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        //najpierw sprawdzam wymiary
        int rows = matrix.length;
        int cols = matrix[0].length;
        //wyswietlenie
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
                if (j != cols - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("|");
        }
    }

    public static int[][] saveToMatrixExample() {
        //definicja tablicy 2D
        int rows = 2;
        int cols = 4;
        int[][] matrix = new int[rows][cols];

        //wypelnienie
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = i +j;
            }
        }
        return matrix;
    }

}

package zajecia;

import java.util.Scanner;

/**
 * Created by RENT on 2017-04-10.
 */
public class Zajecia5 {
    public static void main(String[] args) {

        Zajecia4.displayArray( getArray(10) );
        System.out.println();
        Zajecia4.displayArray( getArray(11) );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert value:");
        int someValue = scanner.nextInt();
        Zajecia4.displayArray( getArray(someValue) );

    }


    public static int[] getArray(int value) {
        //funkcja ma stworzyc tablice parzystych liczb od zero do ostatniej parzystej mniejszej od zadanego value
        //czyli np. dla 11 ma byc od 0 do 10, a dla 10 ma byc od 0 do 8
        //obliczyc size

        //WERSJA PIERWSZA
        //int size = value / 2 + value % 2;  //czyli dla value - 11 mam 11/2 + 11%2 = 5 + 1 = 6 elementów
        //int[] array = new int[size];

        //w petli ustawic wartosci
        //for (int i = 0; i < array.length; i++) {
        //    array[i] = i * 2;
        //}
        //return array;


        //WERSJA DRUGA - dla nieparzystego value dajw wyniku 1, 3, 5, 7, itd... a dla parzystego tak jak bylo
        //wariant 1
        /*
        int size = value / 2; //obojetnie czy parzystych czy nieparzystych liczba elementow w ynikowej tablicy bedzie taka sama
        int[] array = new int[size];
        if (value % 2 == 0) { //parzyste
            for (int i = 0; i < array.length; i++) {
                array[i] = i * 2;
            }
            return array;
        } else { //nieparzyste
            for (int i = 0; i < array.length; i++) {
                array[i] = i * 2 + 1; //dla nieparzystych dodaje jeden, zeby przeskakiwac po nieparzystych
            }
            return array;
        }
        */

        //wariant 2

        int size = value / 2;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + value % 2; //dla parzystych dodaje 0, a dla nieparzystych - 1.
        }
        return array;




    }


}

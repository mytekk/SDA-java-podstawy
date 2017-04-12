package zajecia;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by RENT on 2017-04-11.
 */
public class Zajecia6 {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Give number: ");
//        int number = scanner.nextInt();
//
//        printPowersOf2(35);

//        int[] array = {4, 6, 7, 3, 123, 6, 4, 8, 9, 6, 45, 21, 67, 98};
//        boolean result = sumUntil(array, 150);
//        System.out.println(result);
//        boolean result2 = avgUntil(array, 15);
//        System.out.println(result2);

//        Random random = new Random();
//        int wantedNumber = random.nextInt(100);
//        int result = game(wantedNumber);
//        System.out.println("You finished in " + result + " steps.");

//        int result2 = gameBot(wantedNumber);
//        System.out.println("You finished in " + result2 + " steps.");

//        int result = numberOfDigits(2000);
//        System.out.println("number of digits: " + result);
//
//        int result2 = sumOfDigits(2000);
//        System.out.println("sum of digits: " + result2);

        boolean result = sumOfRandom(75);
        System.out.println("Managed?: " + result);

    }

    public static boolean sumOfRandom(int sum) {
        //losujemy od -10 do 20
        //robimy z tego sume az nie przekroczymy zadanego sum
        Random random = new Random();

        //mam sobie sam generowac losowa tablice, czy mam ja dostac w argumencie?
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30) - 10;
        }

        //wyswietlam tablice
        Zajecia4.displayArray(array);
        System.out.println();

        //sumuje elementy do zadanej wartosci korzystajac z wczesniejszej funkcji, ktora przy okazji zwraca info czy udalo sie dojsc do zadanej wielkosci
        boolean managed = sumUntil(array, sum);

        return managed;

    }

    public static int sumOfDigits(int number) {
        //zwraca sume cyfr w liczbie
        //zliczaj kolejne reszty z dzielenia number przez 10. suma tych reszt to szukana wartosc.
        //po kazdej iteracji pod number podstawiaj wynik dzielenia (te calkowita czesc, a nie reszte) i niech petla trwa tak dlugo az nie dojdziesz z number do 1
        int sum = 0;
        while (number >= 1) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static int numberOfDigits(int number) {
        //zwraca ilosc cyfr w liczbie
        //dziel number przez 10 az nie da w wyniku zero i zliczaj liczbe krokow (dzielimy przez zero bo jestesmy w systemie dziesietnym)
        //liczba krokow to ilosc cyfr w liczbie
        int counter = 1;
        while (number / 10 != 0 ) {
            number = number / 10;
            counter++;
        }
        return counter;
    }

    public static int gameBot(int number) {
        //teraz graczem jest komputer, on sam bedzie zgadywał kolejne strzały
        //gracz tak dlugo podaje liczby dopoki nie trafi w wylosowana liczbe przez komputer
        //komp podpowiada czy podales liczbe wieksza czy mniejsza
        //liczba do zgadniecia bedzie od 0 do 99
        int userChoice = -1; //dla startu, tak, zeby od razu po uruchomieniu programu nie wygrac
        int counter = 0; //ile razy user strzelal

        Random random = new Random();

        while (userChoice != number) {
            System.out.print("Generating next shoot: ");
            userChoice = random.nextInt(100); //komp za slepop zgaduje kolejne wartosci, w koncu trafi
                                                //mozna lepiej, np. zmniejszac lub zwiekszac w zaleznosci od odpowiedzi
            if (userChoice < number) {
                System.out.println("Liczba: " + userChoice + ", pudlo, szukana liczba jest wieksza.");
            }
            else {
                System.out.println("Liczba: " + userChoice + ", pudlo, szukana liczba jest mniejsza.");
            }
            counter++;
        }
        System.out.println("sukces, ilosc krokow to: " + counter + " , szukana liczba to: " + userChoice);
        return counter; //zwracamy ilosc strzalow uzytkownika
    }

    public static int game(int number) {
        //gracz tak dlugo podaje liczby dopoki nie trafi w wylosowana liczbe przez komputer
        //komp podpowiada czy podales liczbe wieksza czy mniejsza
        //liczba do zgadniecia bedzie od 0 do 99
        int userChoice = -1; //dla startu, tak, zeby od razu po uruchomieniu programu nie wygrac
        int counter = 0; //ile razy user strzelal

        Scanner scanner = new Scanner(System.in);

        while (userChoice != number) {
            System.out.print("Give number: ");
            userChoice = scanner.nextInt();
            if (userChoice < number) {
                System.out.println("Pudlo, szukana liczba jest wieksza.");
            }
            else if (userChoice > number) {
                System.out.println("Pudlo, szukana liczba jest mniejsza.");
            }
            counter++;
        }
        System.out.println("sukces, ilosc krokow to: " + counter + " , szukana liczba to: " + userChoice);
        return counter; //zwracamy ilosc strzalow uzytkownika
    }

    public static boolean avgUntil(int[] array, int avg) {
        //to samo co ponizej, ale sprawdzamy, czy srednia wszystkich poprzednich elementow jest mniejsza od czegos
        int arraySum = array[0]; //zaczynamy od pierwszego elementu tablicy
        int i = 1;

        while (arraySum/i < avg && i < array.length) { //w warunku petli obliczamy i sprawdzamy srednia oraz sprawdzamy, czy nie wyszlismy poza tablice
            arraySum +=array[i];
            i++;
        }

        return arraySum/i >= avg;
    }

    public static boolean sumUntil(int[] array, int sum) {
        //sumować elementy tablicy tak dlugo aż nie dojdę do zadanej sumy sum
        //uwaga - czasem moge dojsc do konca tablicy i nie przekroczyc zadanej sumy, wtedy trzeba wyjsc z petli
        int tmpSum = 0;
        int index = 0; //iterator po tablicy
        while (tmpSum <= sum && index < array.length) { //dopoki suma jest mniejsza od zadanrj i dopoki nie wyszedlem z zakresu tablicy
            tmpSum += array[index];
            System.out.println("tmpSum: " + tmpSum + "; sum: " + sum);
            index++;
        }

//        if (tmpSum > sum) {
//            return true;
//        } else {
//            return false;
//        }
        //to co ponizej to to samo co powyzej!!!
        return tmpSum > sum;
    }


    public static void printPowersOf2(int number) {
        //wyswietlapotegi liczby 2, mniejsze od zadanej
        int currentPower = 1;
        while (currentPower < number) {
            System.out.println(currentPower); //wyswietlam bieżącą
            currentPower = currentPower * 2; //podbijam razy dwa i ide do kolejnej iteracji
        }
    }

    public static void whileTest() {
        int number = 10;
        int counter = 0;
        Random random = new Random();

        while (number > 0) {
            System.out.println("Hello world!");
            number -= random.nextInt(3); //number zmniejszamy o losowa liczbe z zakresu 0-3
            counter++;
        }

        System.out.println("counter: " + counter);
    }



}





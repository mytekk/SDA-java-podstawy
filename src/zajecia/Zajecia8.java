package zajecia;

/**
 * Created by RENT on 2017-04-13.
 */
public class Zajecia8 {
    public static void main(String[] args) {

        String message = "Alama Kota.";

        System.out.println("Count of characters: " + countCharacter("ala ma kota i dwa psy", 'a'));
        System.out.println("Number of capitals: " + countCapitalLetter(message));
        System.out.println("Number of small letters: " + countSmallLetter(message));
        System.out.println("Number od words: " + countWords(message));
        System.out.println("Switch case: " + switchCase(message));
        System.out.println("Anonim: " + ananimOf(message));
        System.out.println("Is palindrome: " + isPalindrome(message));
        System.out.println("Starts with 'Ala'? " + startsWith(message, "Ala"));
        System.out.println("Starts with 'Beata'? " + startsWith(message, "Beata"));

    }

    public static String toUpperCase(String message) {
        //w wyniku ma dac stringa rozpoczynajacego sie od duzej litery, niezaleznie jakaprzyszla pierwotna
        return null;
    }

    public static String toLowerCase(String message) {
        //w wyniku ma dac stringa rozpoczynajacego sie od malej litery, niezaleznie jakaprzyszla pierwotna
        return null;
    }

    public static int sumOfNumbers(String message) {
        //Ala ma 2 koty i 35 psy
        //wersja normal zwroci: 2 + 3 +5 = 10
        //wersja premium zwroci: 2 + 35 = 37
        return 0;
    }

    public static boolean startsWith(String message, String someValue) {
        //czy string zaczyna sie od someValue?
        //substring(int startIndex, int endIndex)
        return (message.substring(0, someValue.length() ).equals(someValue));
        //return (message.substring(0, someValue.length() ) == someValue); //na chlopski rozum powinno dzialac
                                                                        //ale nie tutaj, bo == nie da rady !!!!
        // DO POROWNYWANIA STRINGOW UZYWAMY EQUALS !!!
    }

    public static boolean isPalindrome(String message) {
        //return (message == ananimOf(message)) ?  true : false;
        return message.equals(ananimOf(message)); //to jest lepsze rozwiazanie!
    }

    public static String ananimOf(String message) {
        //zwrocic message wspak

        //zamiana stringa natablice pojedynczych znakow
        char[] charArray = message.toCharArray();

        //wariant 1
        //tworze nowa tablice znakow o tej samej dlugosc
        //char[] resultArrray = new char[charArray.length];

        //przechodze przez zadana tablice od przodu i zapisuje od tylu do nowej tablicy
        //for (int i = 0; i < charArray.length; i++) {
        //    resultArrray[resultArrray.length - 1 - i] = charArray[i];
        //}
        //return String.valueOf(resultArrray);

        //wariant 2 - nie towrzymy drugiej tablicy, tylko modyfikujemy wejsciowa
        //zamieniamy elementy miejscami: pierwszy z ostatnim, drugi z przedostatnim itd...
        //az dojdziemy do polowy tablicy - wtedy jest koniec zadania
        for (int i = 0; i < charArray.length / 2; i++) {
            //int a = charArray[i];
            //int b = charArray[charArray.length - 1 - i];
            char tmp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = tmp;
        }
        return String.valueOf(charArray);

    }

    public static String switchCase(String message) {
        //zamiana stringa natablice pojedynczych znakow
        char[] charArray = message.toCharArray();

        //przechodze po tablicy i jesli mam mala litere to zmieniam ja na duza przez odjecie 32 od kodu ascii
        //tej litery, w ten sposob dostane jej duzy odpowiednik
        //w druga strone dodaje 32
        for (int i = 0; i < charArray.length; i++) {
            if ((int)charArray[i] >= 97 && (int)charArray[i] <= 122) { //male na duze
                charArray[i] = (char)(charArray[i] - 32);
            } else if ((int)charArray[i] >= 65 && (int)charArray[i] <= 90) { //duze na male
                charArray[i] = (char)(charArray[i] + 32);
            }

        }
        //return charArray.toString(); - to zwroci krzaczki
        return String.valueOf(charArray);
    }

    public static int countWords(String message) {
        int counter = 0;

        //zamiana stringa natablice pojedynczych znakow
        char[] charArray = message.toCharArray();

        //zlicze wszystkie spacje i zwroce wartosc o jeden mniejsza
        for (int i = 0; i < charArray.length; i++) {
            if ((int)charArray[i]  == 32) {
                counter++;
            }
        }
        return counter + 1;

        //2 wariant
//        return message.split(" ").length;
    }

    public static int countSmallLetter(String message) {
        int counter = 0;

        //zamiana stringa natablice pojedynczych znakow
        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            //if ((int)charArray[i] >= 97 && (int)charArray[i] <= 122) {
            //    counter++;
            //}
            //albo zamiast if-a :
            //counter = ((int)charArray[i] >= 97 && (int)charArray[i] <= 122) ? (counter + 1) : counter;
            //albo jeszcze:
            counter += ((int)charArray[i] >= 97 && (int)charArray[i] <= 122) ? 1 : 0;
        }
        return counter;
    }

    public static int countCapitalLetter(String message) {
        int counter = 0;

        //zamiana stringa natablice pojedynczych znakow
        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if ((int)charArray[i] >= 65 && (int)charArray[i] <= 90) {
                counter++;
            }
        }
        return counter;
    }


    public static int countCharacter(String message, char character) {
        int counter = 0;

        //wariant 1
        //zamiana stringa natablice pojedynczych znakow
//        char[] charArray = message.toCharArray();

        //przechodze przez tablice i zliczam zadany znak
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == character) {
//                counter++;
//            }


        //wariant2
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == character) {
                counter++;
            }
        }

        return counter;
    }

    public static void charAndStringTest() {
        String message = "Ala ma kota";
        message += " i dwa psy.";
        System.out.println(message);

        char znak = 'a';

        //wyswietlenie alfabetu
        for (int i = 0; i < 26; i++) {
            System.out.print(znak + ", ");
            znak++;
        }

        System.out.println();

        char[] charArray =message.toCharArray();
        System.out.println("Message length: " + message.length());
    }


}

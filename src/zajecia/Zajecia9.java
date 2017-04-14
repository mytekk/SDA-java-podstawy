package zajecia;

/**
 * Created by RENT on 2017-04-14.
 */
public class Zajecia9 {
    public static void main(String[] args) {

        System.out.println(cezarCode("wOJNA5Z"));
        System.out.println(cezarDecode("xPKOB6["));
        System.out.println(cezarCode(cezarDecode("Ala ma kota."))); //moglbym zamienic te dwie metody miejscami

        String codedMessage = newCezarCode("Ala ma kota.", 3);
        String decodedMessage = newCezarDecode(codedMessage, -3);
        System.out.println("Coded message: " + codedMessage);
        System.out.println("Decoded message: " + decodedMessage);

    }

    public static String newCezarDecode(String messageToCode, int offset) {
        return cezarCoder(messageToCode, offset);
    }

    public static String newCezarCode(String messageToCode, int offset) {
        return cezarCoder(messageToCode, offset);
    }

    public static String cezarCoder(String message, int offset) {
        //dany znak przepisuje na kolejny w tablicy ascii

        //zamiana stringa na tablice
        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] += offset; //przesuniecie znaku: jesli koduje to dodaje offset, jesli dekoduje to odejmuje offset
        }

        return String.valueOf(charArray);
    }

    public static String cezarDecode(String message) {
        //dany znak przepisuje na poprzedni w tablicy ascii

        //zamiana stringa na tablice
        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            //charArray[i] = (char)(charArray[i] - 1);
            charArray[i]--;
        }

        return String.valueOf(charArray);
    }

    public static String cezarCode(String message) {
        //dany znak przepisuje na kolejny w tablicy ascii

        //zamiana stringa na tablice
        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            //charArray[i] = (char)(charArray[i] + 1);
            charArray[i]++;
        }

        return String.valueOf(charArray);
    }



}

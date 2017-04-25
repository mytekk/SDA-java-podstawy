package zajecia.oop.bookstore;

/**
 * Created by RENT on 2017-04-24.
 */
public class Application {
    public static void main(String[] args) {

        //tworzymy nowa ksiegarnie
        Bookstore bookstore = new Bookstore();

        //wrzucamy przykladow dane
        insertExampleData(bookstore);

        //wyswietlamy wszystkie ksiazki z bookstore
        bookstore.showBooks();

        //liczba ksiazek zadanego autora
        System.out.println(bookstore.getNumberOfBooks("Henryk Sienkiewicz"));

        //zbior - tablica ksiazek zadanego autora
        Book[] booksOfSienkiewicz = bookstore.getBooks("Henryk Sienkiewiczz");
        for (int i = 0; i < booksOfSienkiewicz.length; i++) {
            System.out.println(booksOfSienkiewicz[i]);
        }

        //szukam ksiazki danego autora
        Book bookOfAuthor = bookstore.getBookByAuthor("Henryk Sienkiewicz");
        System.out.println("\nbook of author: " + bookOfAuthor);

        //szukam ksiazki po ISBN
        Book bookByISBN = bookstore.getBook("1234");
        System.out.println("\nBook by ISBN: " + bookByISBN);

        // dygresja
        // w tej chwili moge np dodac nowa ksiazke "recznie", czyli konstruktorem (a nie metoda add) i nie podbić zmiennej numbersofBook
        // moge tez zwiekszyc te zmienna bez dodawania ksiazki
        // efekt: pozostale metody, ktore przechodza w petli po books[] rozjadą mi się, bp np. zakres numberOfBooks
        // bedzie wiekszy niż faktyczna liczba ksiażek
        // by uniknac takiej sytuacji, wszystkie pola w klasie robimy na private :)
        // dla kazdego prywatnego pola tworzymy publiczne settery :)
        // alt + insert -> setter -> wybierz pola prywatne -> ok
        // settery ustawiają dane
        // gettery wyswietlają dane
        // jesli chcemy, zeby np. tytul ksiazki byl niezmienny po jej utworzeniu, to nie tworzymy odpowiedniego settera
        // wtedy tytul bedzie mozna utworzyc tylko raz - przy tworzeniu tego obiektu (w konstruktorze)




    }

    public static void insertExampleData(Bookstore bookstore) {

        //utworzenie nowej ksiazki: obiekt klasy Book
        Book book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", "2001", "1234567890");
        book.setSize(3);

        String[] ogniemIMieczem = new String[3];
        ogniemIMieczem[0] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        ogniemIMieczem[1] = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
        ogniemIMieczem[2] = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        book.setContent(ogniemIMieczem);


        Book book2 = new Book("Potop", "Henryk Sienkiewicz", "2002", "1234567890");
        Book book3 = new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", "2003", "1234567890");
        Book book4 = new Book("Quo vadis", "Henryk Sienkiewicz", "2004", "1234");

        Book book5 = new Book("Dziady 4", "Adam Mickiewicz", "2002", "1234567890");
        String[] dziady4 = new String[3];
        dziady4[0] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        dziady4[1] = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
        dziady4[2] = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        book.setContent(dziady4);

        //zapisanie poszczegolnych ksiazek do bookstore
        bookstore.add(book);
        bookstore.add(book2);
        bookstore.add(book3);
        bookstore.add(book4);
        bookstore.add(book5);
    }

}

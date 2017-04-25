package zajecia.oop.bookstore;

/**
 * Created by RENT on 2017-04-24.
 */
public class Bookstore {

    //klasa Bookstore to "półka z książkami", czyli tablica obiektów klasy Book
    public Book[] books;
    public int numberOfBooks; //licznik książek na półce


    public Bookstore() { //konstruktor bezargumentowy
        this.books = new Book[100]; //każdy nowy obiekt klasy Bookstore będzie mógł zawierać do 100 książek (100-elementowa tablica obiektów klasy Book)
        this.numberOfBooks = 0; //na początku mamy 0 książek
    }

    public boolean add(Book book) {
        //dodaje książkę do bookstore
        boolean valueToReturn = false;
        if (numberOfBooks < 100) {
            books[numberOfBooks] = book; //na pierwszym wolnym miejscu na półce dodaję nową książkę
            valueToReturn = true;
            numberOfBooks++;
        }
        return valueToReturn;
    }

    public void showBooks() {
        for (int i = 0; i < numberOfBooks; i++) { //w petli wywietlam wszystkie ksiazki
            System.out.println(books[i]); //nie musze dawac toString, sout wyszuka go sobie sam :)
        }
    }

    public int getNumberOfBooks(String author) {
        //zwraca liczbe ksiazek danego autora
        int counter = 0;
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].author.equals(author)) { // po lewej jest poprawna wersja tego, co kiedyś bym zapisał tak: books[i].author == author
                counter++;
            }
        }
        return counter;
    }

    public Book[] getBooks(String author) {
        //zwraca tablice ksiazek danego autora
        Book[] bookToReturn = new Book[getNumberOfBooks(author)]; //dlugosc tablicy obliczam z poprzedniej metody
        int index = 0; //index nowej tablicy

        //przechodze po wszystkich ksiazkach
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].author.equals(author)) {
                bookToReturn[index] = books[i];
                index++;
            }
        }
        return bookToReturn;
    }

    public Book getBookByAuthor(String author) {
        //zwraca ksiazke danego autora

        // wariant 1
        //w petli szukam takiego i, dla ktorego warunek jest spelniony
        //warunek: zwiekszaj i dopoki nie zbadasz wszystkich zgromadzonych ksiazek oraz dopoki
        //biezaca ksiazka ma innego autora nic zadanego. Dzieki temu, jesli autor ma wiele ksiazek, to funkcja zwroci
        //pierwsza z jego ksiazek
        int i = 0;
        while (i < numberOfBooks && !books[i].author.equals(author)) {
            i++;
        }
        return i == numberOfBooks ? null : books[i]; //jesli doszedlem z licznikiem do numberOfBook to znaczy, ze nie znalazlem, w przeciwnym razie pod pozycja i bedzie szukana ksiazka

        // wariant 2
        // korzystam w wczesniejszej funkcji zwracajacej tablice ksiazek danego autora. Jesli tablica jest zapelniona (czyli ze sa jakies ksiazki) to zwracam
        // pierwszy jej element, w przeciwnym razie zwracam null
//        Book[] tmp = getBooks(author);
//        Book bookToReturn = null;
//        if (tmp.length > 0) {
//            bookToReturn = tmp[0];
//        }
//        return bookToReturn;
    }

    public Book getBook(String ISBN) {
        //zwraca ksiazke pod ISBN, dziala analogicznie jak poprzednia funkcja, wariant 1
        int i = 0;
        while (i < this.numberOfBooks && !books[i].ISBN.equals(ISBN)) {
            i++;
        }
        return i == this.numberOfBooks ? null : books[i];
    }

}

package zajecia.oop.bookstore;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-24.
 */
public class Book {

    private String title;
    private String description;
    private String author;
    private String releaseDate;
    private int size;
    private String ISBN;
    private String[] content;

    public Book(String title, String author, String releaseDate, String ISBN) { //piszac ten konstruktor tracimy ten domyslny Book()
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.description = "To be updated";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getSize() {
        return size;
    }

    public String getISBN() {
        return ISBN;
    }

    public String[] getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    //tworzenie tego: alx + insert, potem wybierz toString
    //ta funkcja zostanie uzyta zawsze kiedy, bedziemy chcieli wyswietlic jakas ksiazke, np. w sout. Uwaga - nawet nie trzeba bedzie podawac .toString :)
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

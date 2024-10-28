import java.util.HashMap;
import java.util.Map;


class Book {
    private String title;
    private String author;
    private int copies;


    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }


    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Copies: " + copies;
    }
}


public class Library {


    private Map<String, Book> bookMap;

    public Library() {
        bookMap = new HashMap<>();
    }


    public void addBook(String isbn, Book book) {
        bookMap.put(isbn, book);
        System.out.println("Book added: " + book);
    }


    public Book searchBook(String isbn) {
        return bookMap.get(isbn);
    }


    public void removeBook(String isbn) {
        Book removedBook = bookMap.remove(isbn);
        if (removedBook != null) {
            System.out.println("Book removed: " + removedBook);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }


    public void displayAllBooks() {
        if (bookMap.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
                System.out.println("ISBN: " + entry.getKey() + ", " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {

        Library library = new Library();


        library.addBook("978-3-16-148410-0", new Book("War and Peace", "L.N.Tolstoy", 5));
        library.addBook("978-0-14-044913-6", new Book("Crime and Punishment", "Fyodor Dostoevsky", 3));
        library.addBook("978-0-452-28423-4", new Book("The Lower Deths", "Maxim Gorky", 7));


        System.out.println("\nSearching for book with ISBN 978-0-14-044913-6:");
        Book book = library.searchBook("978-0-14-044913-6");
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }


        System.out.println("\nRemoving book with ISBN 978-0-452-28423-4:");
        library.removeBook("978-0-452-28423-4");


        System.out.println("\nDisplaying all books in the library:");
        library.displayAllBooks();
    }
}

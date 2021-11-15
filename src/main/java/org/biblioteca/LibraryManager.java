package org.biblioteca;

import org.biblioteca.models.Book;
import org.biblioteca.models.Rental;
import org.david.Singleton;
import org.david.Unique;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public final class LibraryManager {

    private final Random random = new Random();

    private final Set<Book> books;
    private final Set<Rental> rentals;

    public LibraryManager() throws InstantiationException {
        Singleton.of(this);

        books = new HashSet<Book>();
        rentals = new HashSet<Rental>();
    }

    public void addBook(String title, String author, int pages) {
        books.add(new Book(title, author, pages, nextUniqueID(books)));
    }

    public void addRental(int bookId, String cpf, LocalDate date){
        rentals.add(new Rental(bookId, cpf, date, nextUniqueID(rentals)));
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toUnmodifiableList());
    }

    public Book findBookByAuthor(String author){
        List<Book> books = findBooksByAuthor(author);
        return (books.isEmpty()) ? null : books.get(0);
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findAny()
                .orElse(null);
    }

    public Book findBookById(int id) {
        return books.stream()
                .filter(b -> b.getUniqueId() == id)
                .findAny()
                .orElse(null);
    }

    public boolean wasRented(Book book) {
        return wasRented(book.getUniqueId());
    }

    public boolean wasRented(int bookId) {
        return rentals.stream()
                .anyMatch(r -> r.getBookId() == bookId);
    }

    public void closeRental(Book book){
        Rental rental = rentals.stream()
                .filter(r -> r.getBookId() == book.getUniqueId())
                .findAny().orElse(null);

        if(rental != null)
            rental.close();
    }

    public boolean contains(Collection<? extends Unique> uniqueList, int id){
        return uniqueList.stream()
                .anyMatch(ul -> ul.getUniqueId() == id);
    }

    private int nextUniqueID(Collection<? extends Unique> uniqueList) {
        int randomId = Math.abs(random.nextInt());

        if(contains(uniqueList, randomId))
            return nextUniqueID(uniqueList);

        return randomId;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

}

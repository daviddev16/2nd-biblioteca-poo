package org.biblioteca.models;

import org.biblioteca.LibraryManager;
import org.biblioteca.utils.Matches;
import org.david.Singleton;
import org.david.Unique;

import java.time.LocalDate;

public final class Rental implements Unique {

    private final int uniqueId;
    private final LocalDate date;
    private final String cpf;
    private final int bookId;
    private boolean open;

    public Rental(int bookId, String cpf, LocalDate date, int uniqueId) {
        this.uniqueId = uniqueId;
        this.date = date;
        this.cpf = cpf;
        this.bookId = bookId;
        this.open = true;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPersonCPF() {
        return cpf;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public int getUniqueId() {
        return uniqueId;
    }

    public boolean isClosed() {
        return !open;
    }

    public void close() {
        this.open = false;
    }

    public String toRentalString(LibraryManager libraryManager) {
        return "- \"" + libraryManager.findBookById(bookId).getTitle() + "\" foi alugado dia \"" +
                getDate().format(Matches.DATE_FORMAT) + "\" pelo CPF \"" + getPersonCPF() + "\"";
    }

    @Override
    public String toString() {
        return toRentalString(
                Singleton.getInstance(LibraryManager.class));
    }
}

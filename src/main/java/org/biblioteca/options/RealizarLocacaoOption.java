package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.biblioteca.models.Book;
import org.biblioteca.models.BookProperty;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import java.time.LocalDate;

import static org.david.Requester.freeze;
import static org.david.Requester.request;

@Metadata(name = "Locação", description = "Realizar aluguel de um livro")
public final class RealizarLocacaoOption implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {
        BookProperty property = request(BookProperty.class,
                "Procurar livro por \"ID\", \"Título\" ou \"Autor\" ?");

        Book book = findBookByProperty(property, libraryManager);

        if (book != null)
            doRent(book, libraryManager);
        else
            System.out.println("Livro não encontrado.");

        freeze();
    }

    private Book findBookByProperty(BookProperty property, LibraryManager libraryManager) {
        switch (property) {
            case ID:
                Integer id = request(Integer.class, "Qual o ID do livro? ");
                return libraryManager.findBookById(id);
            case TITLE:
                String title = request(String.class, "Qual o título do livro? ");
                return libraryManager.findBookByTitle(title);
            case AUTHOR:
                String author = request(String.class, "Qual o autor do livro? ");
                return libraryManager.findBookByAuthor(author);
        }
        return null;
    }

    private void doRent(Book book, LibraryManager libraryManager) {
        String cpf = request(String.class, "Qual cpf do cliente: ");
        LocalDate date = request(LocalDate.class, "Data de locação de \"" + book.getTitle() + "\": ");
        libraryManager.addRental(book.getUniqueId(), cpf, date);
        System.out.println(book.getTitle() + " alugado!");
    }

}

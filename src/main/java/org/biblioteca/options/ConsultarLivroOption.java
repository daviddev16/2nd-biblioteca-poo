package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.biblioteca.models.Book;
import org.biblioteca.models.BookProperty;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import java.util.List;

import static org.david.Requester.freeze;
import static org.david.Requester.request;

@Metadata(name = "Consulta", description = "Consultar livro por ID/Título/Autor")
public final class ConsultarLivroOption implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {

        BookProperty property = request(BookProperty.class,
                "Procurar livro por \"ID\", \"Título\" ou \"Autor\" ?");

        displayBook(property, libraryManager);
        freeze();
    }

    private void displayBook(BookProperty property, LibraryManager libraryManager){
        switch (property) {
            case AUTHOR:
                String author = request(String.class, "Qual o nome do autor? ");
                displayBookByAuthor(author, libraryManager);
                break;
            case TITLE:
                String title = request(String.class, "Qual o título do livro? ");
                displayBookByTitle(title, libraryManager);
                break;
            case ID:
                int id = request(Integer.class, "Qual o ID do livro? ");
                displayBookById(id, libraryManager);
                break;
        }
    }

    private void displayBookByAuthor(String author, LibraryManager libraryManager) {
        List<Book> booksByAuthor = libraryManager.findBooksByAuthor(author);
        if (booksByAuthor == null || booksByAuthor.isEmpty()) {
            System.out.println("Esse autor não possui livro.");
            return;
        }
        booksByAuthor.forEach(System.out::println);
    }

    private void displayBookByTitle(String title, LibraryManager libraryManager) {
        Book bookByTitle = libraryManager.findBookByTitle(title);
        if (bookByTitle == null) {
            System.out.println("Título sem correspondência.");
            return;
        }
        System.out.println(bookByTitle);
    }

    private void displayBookById(int id, LibraryManager libraryManager) {
        Book bookByTitle = libraryManager.findBookById(id);
        if (bookByTitle == null) {
            System.out.println("ID sem correspondência.");
            return;
        }
        System.out.println(bookByTitle);
    }

}

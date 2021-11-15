package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.biblioteca.models.Book;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import static org.david.Requester.freeze;

@Metadata(name = "Relatório 1", description = "Lista de livros")
public final class Relatorio1Option implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {

        for(Book book : libraryManager.getBooks())
            System.out.println(book.toString());

        freeze();
    }


}

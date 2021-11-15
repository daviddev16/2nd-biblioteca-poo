package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.biblioteca.models.Rental;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import java.util.List;
import java.util.stream.Collectors;

import static org.david.Requester.freeze;

@Metadata(name = "Relatório 3", description = "Livros com aluguel em aberto")
public final class Relatorio3Option implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {

        List<Rental> rentals = libraryManager.getRentals().stream()
                .filter(r -> !r.isClosed())
                .collect(Collectors.toUnmodifiableList());

        if (rentals != null && !rentals.isEmpty())
            rentals.forEach(System.out::println);
        else
            System.out.println("Nenhum livro com devolução aberta.");

        freeze();
    }

}

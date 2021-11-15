package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.biblioteca.models.Rental;
import org.biblioteca.utils.Matches;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.biblioteca.utils.Utilities.between;
import static org.david.Requester.freeze;
import static org.david.Requester.request;

@Metadata(name = "Relatório 2", description = "Livros alugados por período")
public final class Relatorio2Option implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {

        LocalDate start = request(LocalDate.class, "Data inicial ∙ Atualmente " + LocalDate.now()
                .format(Matches.DATE_FORMAT) + " :");

        LocalDate end = request(LocalDate.class, "Data final: ");

        if (end.isBefore(start)) {
            System.out.println("Data final anterior a data inicial.");
        } else {
            List<Rental> rentals = libraryManager.getRentals().stream()
                    .filter(between(start, end)).collect(Collectors.toUnmodifiableList());

            if (rentals != null && !rentals.isEmpty()) {
                rentals.forEach(System.out::println);
            } else {
                System.out.println("Nenhum livro encontrado dentro desse período.");
            }
        }

        freeze();
    }

}

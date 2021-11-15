package org.biblioteca;

import org.biblioteca.models.BookProperty;
import org.biblioteca.options.*;
import org.biblioteca.utils.Matches;
import org.david.Requester;
import org.david.Selector;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InstantiationException {

        Requester.handle(BookProperty.class, Matches::nextBookProperty);
        Requester.handle(LocalDate.class, Matches::nextLocalDate);

        LibraryManager libraryManager = new LibraryManager();

        Selector.of(libraryManager)
                .option(new CadastrarLivroOption())
                .option(new ConsultarLivroOption())
                .option(new RealizarLocacaoOption())
                .option(new RealizarDevolucaoOption())
                .option(new Relatorio1Option())
                .option(new Relatorio2Option())
                .option(new Relatorio3Option())
                .option(new SairOption())
                .run();

    }

}

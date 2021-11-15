package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

@Metadata(name = "Sair", description = "Fechar aplicação")
public final class SairOption implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager libraryManager) {
        Runtime.getRuntime().exit(0);
    }

}

package org.biblioteca.options;

import org.biblioteca.LibraryManager;
import org.david.Option;
import org.david.Selector;
import org.david.annotations.Metadata;

import static org.david.Requester.freeze;
import static org.david.Requester.request;

@Metadata(name = "Cadastro", description = "Adicionar livro na biblioteca")
public final class CadastrarLivroOption implements Option<LibraryManager> {

    @Override
    public void display(Selector selector, LibraryManager manager) {
        String title = request(String.class, "Digite o nome do livro: ");
        String author = request(String.class, "Digite o nome do author: ");
        Integer pages = request(Integer.class, "Digite o numero de páginas: ");
        manager.addBook(title, author, pages);
        System.out.println("\"" + title + "\" por \"" + author + "\" foi adicionado.");
        freeze();
    }

}

package org.david;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.david.Utils.clearConsole;

public final class Selector<E> {

    private final List<Option<E>> options;
    private boolean running = false;
    private final E handled;

    private Selector(E handled) {
        this.options = new ArrayList<>();
        this.handled = Objects.requireNonNull(handled, "Objeto manipulado nulo.");
    }

    public static <E> Selector<E> of(E handled) {
        return new Selector<>(handled);
    }

    private void displayOptions() {
        Screens.displayOptions(options);
    }

    private Option<E> chooseOption() {
        Integer selectedOption = Requester.request(Integer.class, "Selecione uma opção: ");
        if (selectedOption < 0 || selectedOption >= options.size()) {
            System.out.println("Opção inválida.");
            return chooseOption();
        }
        return options.get(selectedOption);
    }

    public Selector<E> option(final Option<E> option) {
        Objects.requireNonNull(option, "Opção nula.");
        if (!options.contains(option))
            options.add(option);
        return this;
    }

    private void displayChooseOption() {
        Option<E> option = chooseOption();
        clearConsole();
        option.display(this, handled);
    }

    public void run() {
        if (!running) {
            running = true;
        }
        /* main loop */
        do {
            clearConsole();
            displayOptions();
            displayChooseOption();
        } while (running);
    }

    public void exit() {
        running = false;
    }

}

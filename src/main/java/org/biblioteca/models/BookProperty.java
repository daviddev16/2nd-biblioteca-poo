package org.biblioteca.models;

import java.util.Arrays;
import java.util.stream.Stream;

public enum BookProperty {

    ID("id", "identificação"),
    TITLE("título", "titulo", "title"),
    AUTHOR("autor", "author");

    private String[] names;

    BookProperty(String... name) {
        if (name != null)
            names = Arrays.copyOf(name, name.length);
    }

    public static BookProperty valueByName(String name) {
        for (BookProperty property : values()) {
            if (property.checkName(name)) {
                return property;
            }
        }
        throw new IllegalArgumentException("Invalid name: " + name);
    }

    public boolean checkName(String name) {
        return Stream.of(names).anyMatch(n -> n.equalsIgnoreCase(name));
    }

}

package org.biblioteca.utils;

import org.biblioteca.models.BookProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public final class Matches {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static <E> E nextMatch(Scanner scanner, Function<String, E> function) {
        try {
            String input = scanner.next();
            return function.apply(input.trim());
        } catch (Exception e) {
            throw new InputMismatchException(e.getMessage());
        }
    }

    public static BookProperty nextBookProperty(Scanner scanner) {
        return nextMatch(scanner, BookProperty::valueByName);
    }

    public static LocalDate nextLocalDate(Scanner scanner) {
        return nextMatch(scanner, Matches::parseDateTime);
    }

    private static LocalDate parseDateTime(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMAT);
    }


}

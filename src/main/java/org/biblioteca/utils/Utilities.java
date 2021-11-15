package org.biblioteca.utils;

import org.biblioteca.models.Rental;

import java.time.LocalDate;
import java.util.function.Predicate;

public class Utilities {

    public static Predicate<Rental> between(LocalDate min, LocalDate max) {
        return rental -> rental.getDate().isAfter(min) && rental.getDate().isBefore(max);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}

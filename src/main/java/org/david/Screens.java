package org.david;

import java.util.List;

import static org.biblioteca.utils.Utilities.isNullOrEmpty;

public final class Screens {

    private Screens() {
    }

    public static <E> void displayOptions(List<Option<E>> options) {
        StringBuffer builder = new StringBuffer();
        builder.append(String.format("+-- Numero --+---------- Nome ----------+----------------- Descrição -----------------+%n"));
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);

            String name = !isNullOrEmpty(option.getName()) ? option.getName() : "Sem nome";
            String description = !isNullOrEmpty(option.getDescription()) ? option.getDescription() : "Sem descrição";

            builder.append(String.format("| %-10s | %-24s | %-43s |%n", center(Integer.toString(i), 10),
                    center(name, 24), center(description, 43)));
        }
        builder.append(String.format("+------------+--------------------------+---------------------------------------------+%n"));
        System.out.println(builder.toString());
    }

    public static String center(String str, int length) {
        if (str.length() == length)
            return str;
        else if (str.length() > length)
            return str.substring(0, length - 3) + "...";

        str = str.trim();
        int paddingLength = (length - str.length()) / 2;
        String lrPadding = fill(' ', paddingLength);
        return lrPadding + str + lrPadding;

    }

    public static String fill(char fillChar, int length) {
        String fillString = "";
        for (int i = 0; i < length; i++) {
            fillString += fillChar;
        }
        return fillString;
    }

}

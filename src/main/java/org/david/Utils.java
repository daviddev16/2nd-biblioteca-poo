package org.david;

public class Utils {

    public static void clearConsole() {
        try {
            /* So funciona com o plugin "Grep Console" do intellij. */
            if (System.getProperty("user.dir").contains("IdeaProjects")) {
                System.out.print(".*unwanted line.*");
            } else if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
            }
            System.out.println();
        } catch (Exception ignore) {
        }
    }

}

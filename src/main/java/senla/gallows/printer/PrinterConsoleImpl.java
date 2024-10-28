package senla.gallows.printer;

import java.util.Map;

public class PrinterConsoleImpl implements Printer {

    private static final Map<Integer, String> GALLOWS_PICTURES = Map.of(
            5, """
                      Lives count = 5
                      +---+
                      |   |
                          |
                          |
                          |
                      T   |
                    =========""",
            4, """
                      Lives count = 4
                      +---+
                      |   |
                      O   |
                          |
                          |
                      T   |
                    =========""",
            3, """
                      Lives count = 3
                      +---+
                      |   |
                      O   |
                      |   |
                          |
                      T   |
                    =========""",
            2, """
                      Lives count = 2
                      +---+
                      |   |
                      O   |
                     /|\\  |
                          |
                      T   |
                    =========""",
            1, """
                      Lives count = 1
                      +---+
                      |   |
                      O   |
                     /|\\  |
                      /\\  |
                      T   |
                    =========""",
            0, """
                      Lives count = 0
                      +---+
                      |   |
                      \\   |
                     /|\\  |
                      /\\  |
                          |
                    =========
                    You lose((( try again!
                    """
    );
    private static final String WIN_PICTURE =
            """
                    __     ______  _    _  __          _______ _   _\s
                    \\ \\   / / __ \\| |  | | \\ \\        / /_   _| \\ | |
                     \\ \\_/ / |  | | |  | |  \\ \\  /\\  / /  | | |  \\| |
                      \\   /| |  | | |  | |   \\ \\/  \\/ /   | | | . ` |
                       | | | |__| | |__| |    \\  /\\  /   _| |_| |\\  |
                       |_|  \\____/ \\____/      \\/  \\/   |_____|_| \\_|""";


    @Override
    public void printInfoWithPicture(final int livesCount, final char[] word) {
        System.out.println(GALLOWS_PICTURES.get(livesCount));
        System.out.println(word);
        System.out.println("enter the letter and press return:");
    }

    @Override
    public void printResult(final boolean win) {
        if (win) {
            System.out.println(WIN_PICTURE);
        }
    }

}

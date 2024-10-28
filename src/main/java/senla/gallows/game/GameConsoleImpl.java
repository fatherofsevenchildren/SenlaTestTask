package senla.gallows.game;

import senla.gallows.printer.Printer;
import senla.gallows.printer.PrinterConsoleImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameConsoleImpl implements Game {

    private static final int START_LIVES_COUNT = 5;
    private static final List<String> WORDS = List.of(
            "childhood", "eyebrow", "stomach", "daughter", "strawberry",
            "girlfriend", "banana", "chicken", "cucumber", "mushroom");

    private int livesCount = START_LIVES_COUNT;
    private boolean win = false;
    private final String findingWord;
    private final char[] hiddenWord;
    private final Printer printer;

    public GameConsoleImpl() {
        this.findingWord = WORDS.get(ThreadLocalRandom.current().nextInt(WORDS.size()));
        this.hiddenWord = new char[findingWord.length()];
        Arrays.fill(hiddenWord, '_');
        this.printer = new PrinterConsoleImpl();
    }

    @Override
    public void lunch() {
        printer.printInfoWithPicture(livesCount, hiddenWord);
        Scanner scanner = new Scanner(System.in);
        while (livesCount > 0 && !win) {
            printLatter(scanner.next());
        }
        printer.printResult(win);
        scanner.close();
    }

    private void printLatter(final String Latter) {
        if (Latter.length() != 1) {
            System.out.println("please write 1 char");
        } else if (findingWord.contains(Latter.toLowerCase())) {
            unhideLetter(Latter.charAt(0));
            checkWin();
        } else {
            livesCount--;
        }
        printer.printInfoWithPicture(livesCount, hiddenWord);
    }

    private void unhideLetter(final char letter) {
        int index = findingWord.indexOf(letter);
        while (index >= 0) {
            hiddenWord[index] = letter;
            index = findingWord.indexOf(letter, index + 1);
        }
    }

    private void checkWin() {
        for (char c : hiddenWord) {
            if (c == '_') {
                return;
            }
        }
        win = true;
    }

}

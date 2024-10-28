package senla.gallows;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameConsoleImpl implements Game{

    private static final List<String> WORDS = List.of(
            "childhood", "eyebrow", "stomach", "daughter", "strawberry",
            "girlfriend", "banana", "chicken", "cucumber", "mushroom");

    private int lives;
    private boolean win;
    private final String word;
    private final char[] hiddenWord;
    private final Scanner scanner;

    public GameConsoleImpl() {
        this.lives = 5;
        this.win = false;
        this.word = WORDS.get(ThreadLocalRandom.current().nextInt(WORDS.size()));
        this.hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_');
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void lunch() {
        while (lives > 0 && !win) {
            System.out.println(hiddenWord);
            System.out.println("enter the letter an press return");
            String scannedChar = scanner.next();
            if (scannedChar.length() != 1) {
                System.out.println("please write 1 char");
            } else if (word.contains(scannedChar.toLowerCase())) {
                printLetter(scannedChar.charAt(0));
                checkWin();
            } else {
                lives--;
            }
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

    private void printLetter(char currentChar) {
        int index = word.indexOf(currentChar);
        while (index >= 0) {
            hiddenWord[index] = currentChar;
            index = word.indexOf(currentChar, index + 1);
        }
    }
}

package senla.gallows.printer;

public interface Printer {
    void printInfoWithPicture(int livesCount, char[] word);
    void printResult(boolean win);
}

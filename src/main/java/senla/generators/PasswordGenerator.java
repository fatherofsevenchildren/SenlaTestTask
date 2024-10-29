package senla.generators;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passwordLength = validatePasswordLength(scanner);
        String password = generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);
    }

    private static int validatePasswordLength(Scanner scanner) {
        int length = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите длину пароля (от 8 до 12): ");
            try {
                length = scanner.nextInt();
                if (length >= 8 && length <= 12) {
                    validInput = true;
                } else {
                    System.out.println("Ошибка: длина пароля должна быть от 8 до 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
        return length;
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(randomIndex));
        }
        return password.toString();
    }
}

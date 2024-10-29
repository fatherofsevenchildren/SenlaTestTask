package senla.converters;

import java.util.Scanner;

import static senla.converters.Currency.CURRENCIES;
import static senla.converters.Currency.CURRENCY_COUNT;

public class CurrencyConverterApplication {

    private static final String MAIN_MENU = """
            Какую валюту вы хотите конвертировать?
            1.USD
            2.EUR
            3.GBP
            4.JPY
            5.RUB
            введите номер:""";

    private static final String WRONG_NUMBER = "введите число от 1 до 5";
    private static final String WRONG_AMOUNT =
            "некорректная сумма, введите например: 100.00";

    private int currencyNumber;
    private Currency currency;
    private final Scanner scanner = new Scanner(System.in);


    public void start() {
        System.out.print(MAIN_MENU);
        currency = getCurrency();
        convert(getAmount());
        scanner.close();
    }

    private Currency getCurrency() {
        while (!scanner.hasNextInt()
                || (currencyNumber = scanner.nextInt()) > CURRENCY_COUNT || currencyNumber < 1) {
            System.out.println(WRONG_NUMBER);
            scanner.next();
        }
        return CURRENCIES.get(currencyNumber - 1);
    }

    private void convert(final double amount) {
        for (int i = 0; i < CURRENCY_COUNT; i++) {
            if (i != currencyNumber - 1) {
                CURRENCIES.get(i).printAmountInCurrency(amount, currency);
            }
        }
    }

    private double getAmount() {
        System.out.format("Введите сумму в %s: ", currency.name());
        while (!scanner.hasNextDouble()) {
            System.out.println(WRONG_AMOUNT);
            scanner.next();
        }
        return scanner.nextDouble();
    }

}

package senla.converters;

import java.util.List;

public record Currency(String name, double rateToUSD) {

    public static final int CURRENCY_COUNT = 5;

    public static final List<Currency> CURRENCIES = List.of(
            new Currency("USD", 1.0),
            new Currency("EUR", 0.9),
            new Currency("GBP", 0.8),
            new Currency("JPY", 110.0),
            new Currency("RUB", 97.0)
    );

    public void printAmountInCurrency(double amount, Currency targetCurrency) {
        double amountInCurrency = amount * this.rateToUSD() / targetCurrency.rateToUSD();
        System.out.printf("Сумма в %s: %.2f%n", name(), amountInCurrency);
    }
}

package senla.gallows;

import senla.gallows.game.Game;
import senla.gallows.game.GameConsoleImpl;

public class Application {
    public static void main(String[] args) {
        Game game = new GameConsoleImpl();
        game.lunch();
    }
}
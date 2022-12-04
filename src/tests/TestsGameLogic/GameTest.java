package TestsGameLogic;

import main.GameLogic.Game;
import main.GameLogic.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void gameLoop() {
    }

    @Test
    void getPlayers() {
    }

    @Test
    void getMostSuccessfulPlayers() {
        Game game = new Game(6000,3);

        Player player1 = new Player("a");
        player1.Score = 100;
        Player player2 = new Player("a");
        player2.Score = 500;
        Player player3 = new Player("a");
        player3.Score = 60000;

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        game.players = players;

        game.getMostSuccessfulPlayers();
        assertEquals(1, game.getMostSuccessfulPlayers().size());
    }

    @Test
    void forceWin() {
    }
}
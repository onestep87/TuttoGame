package tests;

import Dice.DiceLogic;
import Dice.Die;
import GameLogic.Game;
import GameLogic.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiceLogicTest {

    @Test
    void throwDices() {
        assertEquals(3, DiceLogic.ThrowDices(3).size());
        assertEquals(1, DiceLogic.ThrowDices(1).size());
        assertEquals(6, DiceLogic.ThrowDices(6).size());
    }

    @Test
    void getCombinations() {
//        Game game = new Game(6000);
//
//        Player player1 = new Player();
//        player1.Score = 100;
//        Player player2 = new Player();
//        player1.Score = 500;
//        Player player3 = new Player();
//        player1.Score = 60000;
//
//        ArrayList<Player> players = new ArrayList<>();
//        players.add(player1);
//        players.add(player2);
//        players.add(player3);
//
//        game.players = players;
//
//        game.getMostSuccessfulPlayers();
//        assertEquals(1, game.getMostSuccessfulPlayers().size());
    }
}
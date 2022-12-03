package GameLogic;

import Cards.Card;
import Cards.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> deck;
    public CardDeck(){
        initCards();
        shuffle();
    }
    public Card takeCard() throws Exception {

        if(deck == null){
            initCards();
            shuffle();
        }
        if(deck.size() == 0){
            initCards();
            shuffle();
        }

        return deck.pop();
    }

    public void shuffle(){
        Random rand = new Random();

        for (int i = 0; i < deck.size(); i++) {
            int randomIndexToSwap = rand.nextInt(deck.size());
            Card temp = deck.get(randomIndexToSwap);
            deck.set(randomIndexToSwap, deck.get(i));
            deck.set(i, temp);
        }
    }

    private void initCards(){
        deck = new Stack<>();
        for(int i = 0; i < Cloverleaf.Count; i++)
            deck.push(new Cloverleaf());
//        for(int i = 0; i < Fireworks.Count; i++)
//            deck.push(new Fireworks());
//        for(int i = 0; i < PlusMinus.Count; i++)
//            deck.push(new PlusMinus());
//        for(int i = 0; i < StopCard.Count; i++)
//            deck.push(new StopCard());
//        for(int i = 0; i < StraightCard.Count; i++)
//            deck.push(new StraightCard());
//        for(int i = 0; i < x2Card.Count; i++)
//          deck.push(new x2Card());
//        for(int i = 0; i < BonusCard.Count200; i++)
//            deck.push(new BonusCard(200));
//        for(int i = 0; i < BonusCard.Count300; i++)
//            deck.push(new BonusCard(300));
//        for(int i = 0; i < BonusCard.Count400; i++)
//            deck.push(new BonusCard(400));
//        for(int i = 0; i < BonusCard.Count500; i++)
//            deck.push(new BonusCard(500));
//        for(int i = 0; i < BonusCard.Count600; i++)
//            deck.push(new BonusCard(600));
    }
}

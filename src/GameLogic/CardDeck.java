package GameLogic;

import Abstract.Card;
import Cards.BonusCard;

public class CardDeck {
    public Card takeCard(){
        return new BonusCard();
    }
}

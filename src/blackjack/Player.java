package blackjack;

public class Player {
    private final String Name;
    private int Score;
    private Card[] playerCards = new Card[11];
    public int cardsNum = 0;

    public Card[] getCard(){
        return playerCards;
    }
    public Player(String Name){
        this.Name = Name;
    }
    public int getScore(){
        return Score;
    }
    
    public String getName(){
        return Name;
    }
    
    public void addcard(Card card)
    {
        if(cardsNum < 11)
        {
            playerCards[cardsNum] = card;
            this.Score += card.getValue();
        }
        else
        {
            return;
        }
        cardsNum++;
    }

}
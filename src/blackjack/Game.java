package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public Player[] players = new Player[4];
    public Card[] cards = new Card[52];
    private int highestScore;

    public void GenerateCards(){
        for (int i = 0 ; i < 13 ; i++) {
            if (i < 10) {
                cards[i] = new Card(0, i, i + 1);
            }
            else {
                cards[i] = new Card(0, i, 10);
            }
        }
        for (int i = 13 ; i < 26 ; i++) {
            if (i < 23) {
                cards[i] = new Card(1, i - 13, (i - 13) + 1);
            }
            else {
                cards[i] = new Card(1, i - 13, 10);
            }
        }
        for (int i = 26 ; i < 39 ; i++){
            if(i < 36){
                cards[i] = new Card(2,i - 26 , (i - 26)+1);
            }
            else {
                cards[i] = new Card(2, i - 26, 10);
            }
        }
        for (int i = 39 ; i < 52 ; i++){
            if(i < 49){
                cards[i] = new Card(3,i - 39,(i - 39)+1);
            }
            else {
                cards[i] = new Card(3, i - 39, 10);
            }
        }
    }
    
    
    public Card Draw(){
        Random rand = new Random();
        int randNum = rand.nextInt(52);
        Card drawncard = null;
        while(drawncard == null)
        {
            drawncard = cards[randNum];
            cards[randNum] = null;
            randNum = rand.nextInt(52);
        }
        return drawncard;
    }
    
    
    public void StartingGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter player name");
        
        for(int i = 0; i < 3; i++)
        {
            players[i] = new Player(input.next());
            for(int j = 0; j < 2; j++)
            {
                players[i].addcard(Draw());
            }
        }
        
        
        players[3] = new Player("Dealer");
        for(int k = 0; k < 2; k++)
        {
            players[3].addcard(Draw());
        }
    }

    
}

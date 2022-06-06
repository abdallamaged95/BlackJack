package blackjack;
import java.util.Random;
import java.util.Scanner;
public class BlackJack {
    static Game game = new Game();
    
    public static void main(String[] args)
    {
        GUI gui = new GUI();
        int status , blackjack = 0;
        String win = "";
        Scanner input = new Scanner(System.in);
        game.GenerateCards();
        game.StartingGame();
        gui.runGUI(game.cards , game.players[0].getCard() , game.players[1].getCard() , game.players[2].getCard() , game.players[3].getCard());
        for (int i = 0 ; i < 4 ; i++){
            while(game.players[i].cardsNum < 11){
                System.out.printf("%s score %d Choose :\n",game.players[i].getName(),game.players[i].getScore());
                System.out.println("1) Hit");
                System.out.println("2) Stand");
                status = input.nextInt();
                if (status == 1){
                    Card card = game.Draw();
                    game.players[i].addcard(card);
                    gui.updatePlayerHand(card,i);
                    if (game.players[i].getScore() > 21){
                        System.out.printf("%s is Busted\n",game.players[i].getName());
                        break;
                    }
                    else if (game.players[i].getScore() == 21){
                        System.out.printf("%s has Black Jack\n",game.players[i].getName());
                        win += game.players[i].getName();
                        blackjack++;
                        break;
                    }
                }
                else if (status == 2) break;
            }
        }
        int [] score = new int[4];
        for (int i = 0 ; i < 4 ; i++){
            if (game.players[i].getScore() < 21){
                score[i] = game.players[i].getScore();
            }
        }
        int highest = 0;
        for (int i = 0 ; i < 4 ;i++){
            if (game.players[i].getScore() > highest && game.players[i].getScore() <= 21){
                highest = game.players[i].getScore();
                win = game.players[i].getName();
            }
        }
        if (blackjack > 1) {
            System.out.println("It is a tie");
        }
        else System.out.print(win +" has the highest score  "+highest);
    }
}
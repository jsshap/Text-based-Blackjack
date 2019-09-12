import java.util.ArrayList;
import java.util.Scanner;
public class HumanPlayer extends Player {
    public static Scanner keyboard = new Scanner (System.in);
    public String name;


    public HumanPlayer(String s){
	balance=50;
	name = s;
	hand = new ArrayList<Card>();
    }


    public int playHand(Deck deck){
		int total= 0;
		while (true){
	    
		    System.out.println("Your hand:");
		    for (Card c : hand){
				System.out.println(c);
		    }
	    sortHand(this.hand);
	    total = this.computeHandValue();
	    if (total>21){
		System.out.println("You busted");
		return 0;
	    }
	    System.out.println("Total is: " + total);
	    System.out.println ("Hit or Stand?: ");
	    if (keyboard.nextLine().toLowerCase().charAt(0) =='h'){
		hand.add(deck.drawCard());	
	    }
	    else
		break;
	}
	total = this.computeHandValue();
	System.out.println();
	System.out.println();
	return total;
	
    }


	
}

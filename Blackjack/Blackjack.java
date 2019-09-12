import java.util.Scanner;
import java.util.ArrayList;
public class Blackjack{
    public static Scanner keyboard = new Scanner (System.in);
    public static void main(String[] args){
	System.out.println("Let's start. Enter your name: ");
	String name = keyboard.nextLine();
	Player human = new HumanPlayer(name);
	Player cpu = new ComputerPlayer();
	Deck deck = new Deck();

	while (true){
	    if (deck.getCardsRemaining()<20)
		deck=new Deck();
	    //Creates new deck with all cards back in it
	    deal(deck, human, cpu);
	    System.out.println("Your balance is $" + human.balance);
	    int bet=takeBet(human);
	    for(int i=0; i<25; i++){
		System.out.println();
	    }
	    System.out.println("Dealer shows " + cpu.hand.get(1));	    
	    int playerScore = human.playHand(deck);
	    if (playerScore == 0){
		human.balance -= bet;
	    }
	    else {
		int cpuScore = cpu.playHand(deck);
		System.out.println("Here is the dealer's hand");
		for (Card c : cpu.hand){
		    System.out.println(c);
		}
		if (cpuScore == 0){
		    System.out.println("Dealer busted");
		}
		else{
		    System.out.println ("Dealer has " + cpuScore);
		}
		System.out.println();
		System.out.println ("You have " + playerScore);
		if (cpuScore>playerScore){
		    human.balance -= bet;
		    System.out.println ("Dealer wins and you lose $" + bet);
		}
		else if (playerScore>cpuScore){
		    human.balance += bet;
		    System.out.println("You win $" + bet);
		}
		else{
		    System.out.println("It's a tie");
		}
		System.out.println();
	    
	    }
	    resetHands(human, cpu);
	    System.out.println();
	    if (human.balance<1){
		System.out.println("You're out of money....");
		System.exit(0);
	    }
	    
		    
	    
	    
	}
    }
    public static void deal(Deck deck, Player human, Player cpu){
	human.hand.add(deck.drawCard());
	human.hand.add(deck.drawCard());
	cpu.hand.add(deck.drawCard());
	cpu.hand.add(deck.drawCard());
    }
    public static int takeBet(Player h){
	System.out.print("Enter your bet: ");
	int bet=0;
	try {bet = keyboard.nextInt();}
	catch (Exception e) {
	    keyboard.nextLine();
	    System.out.println("That's not a number. Try again.");
	    takeBet(h);
	}
	if (bet>h.balance){
	    System.out.println("You can't afford that!");
	    takeBet(h);
	}
	return bet;
		
	    
    }
    public static void resetHands(Player h, Player c){
	h.hand = new ArrayList<Card>();
	c.hand = new ArrayList<Card>();
    }
}

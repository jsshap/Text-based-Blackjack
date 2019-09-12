import java.util.Scanner;
import java.util.ArrayList;
public class Oddstest{
    public static Scanner keyboard = new Scanner (System.in);
    public static void main(String[] args){

	ComputerPlayer cpu = new ComputerPlayer();
	ComputerPlayer cpu2 = new ComputerPlayer();

	double cpu1wins=0;
	double cpu2wins=0;
	double ties=0;
	Deck deck = new Deck();
	
	for (int i=0; i<1000000; i++){

	    if (deck.getCardsRemaining()<20)
		deck = new Deck();//Creates new deck with all cards
	    deal(deck, cpu2, cpu);
	    int playerScore = cpu2.playHand(deck);
	    if (playerScore == 0){
		cpu1wins++;
	    }
	    else {
		int cpuScore = cpu.playHand(deck);
		
		if (cpuScore>playerScore){
		    cpu1wins++;
		}
		else if (playerScore>cpuScore){
		    cpu2wins++;
		}
		else
		    ties++;
	    }
	    resetHands(cpu2, cpu);
	    
	}
	
	    
	System.out.println((cpu1wins+" , "+cpu2wins+" , " + ties));//dealer wins, player, total
	System.out.println(cpu1wins/cpu2wins);//dealer wins odds ratio
	System.out.println(cpu1wins/(1000000-ties)+" , " + (cpu2wins/(1000000-ties)));//percentage of non-ties won by dealer, player
	System.out.println((cpu1wins/(1000000))+" , "+(cpu2wins/1000000)+ " , "+ (ties/1000000));// dealer win %, player win %, tie %
    }
    public static void deal(Deck deck, ComputerPlayer human, ComputerPlayer cpu){
	human.hand.add(deck.drawCard());
	human.hand.add(deck.drawCard());
	cpu.hand.add(deck.drawCard());
	cpu.hand.add(deck.drawCard());
    }

    public static void resetHands(ComputerPlayer h, ComputerPlayer c){
	h.hand = new ArrayList<Card>();
	c.hand = new ArrayList<Card>();
    }
}

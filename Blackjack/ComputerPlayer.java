import java.util.ArrayList;
public class ComputerPlayer extends Player {


    public ComputerPlayer(){
	hand = new ArrayList<Card>();
	balance=100000000;
    }
    
    public int playHand(Deck deck){
	int score=computeHandValue();
	while (true){    
	    if (score<17){
		hand.add(deck.drawCard());
		sortHand(hand);
		score=computeHandValue();
	    }
	    if (score<22 && score>16)
		return score;
	    if (score>21)
		return 0;	    
	}
    }


}

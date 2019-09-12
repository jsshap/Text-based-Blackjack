import java.util.Scanner;
public class Deck {

    /******************************************************************************

    A Deck object represents a deck of cards.

    ******************************************************************************/

    private Card[] cards;             // The cards
    public int cardsLeft;            // The number of cards not yet drawn.
                                 // Make sure that the undrawn cards are in
                                     // positions 0 through cardsLeft-1.
    /************************ constructors ***************************************/

    public Deck() {                  // This constructor creates a standard deck

	cards = new Card[52];
	int k=0;
	
	for (int i=0; i<4; i++)
	    for (int j=2; j<15; j++){
		cards[k]= new Card (j, i);
		k++;
		    }
	    

	shuffle();
	
	cardsLeft = 52;
	/*	for (int i=0; i<52; i++)
		System.out.println (cards[i]);*/
    }

    /***************************************************************************
    drawCard(): This method returns a Card from the deck.  It should
         return null if the deck is empty.
    ****************************************************************************/

    public Card drawCard() {
	// To draw a card, it isn't necessary to change the contents of the array.
	// But you do want to make sure that each card can be drawn only once.
	// Do you see how to do this?  (Hint: it's easiest to draw cards from the
	// high end of the array.)
	
	if (cardsLeft==0)
	    return null;
	cardsLeft--;
	return (this.cards[cardsLeft]);
    
    }


    /***************************************************************************
    getCardsRemaining(): This method tells how many cards remain in the deck.
    ****************************************************************************/

    public int getCardsRemaining() {

	return cardsLeft;

    }

    /***************************************************************************
    shuffle(): This method shuffles the deck.
    ****************************************************************************/

    public void shuffle() {

	cardsLeft = cards.length;
	for (int i=cards.length-1; i>=0; --i) {

	    int r = (int)(Math.random()*(i+1));  // pick a random pos <= i

	    Card t = cards[i];
	    cards[i] = cards[r];
	    cards[r] = t;

	}
    }

    /***************************************************************************
    main(): This method is used for testing the Deck class
    ****************************************************************************/
    
    public static void main (String[] args) {
	Scanner keyboard = new Scanner(System.in);

	Deck d = new Deck();
	System.out.print ("Hit enter to draw a card. ");
	while (d.cardsLeft!=0){
	    keyboard.nextLine();
	    System.out.print (d.drawCard());
	}
	System.out.println();
	
    }
}

	    

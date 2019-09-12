import java.util.ArrayList;

public abstract class Player {
    public ArrayList<Card> hand;
    public int balance;


    int computeHandValue(){
        int value=0;
        for (Card c : hand){
            if (c.getValue()>=10 && c.getValue()!=14){
                value += 10;
            }
            else if (c.getValue()==14){
                if (value<=10){
                    value+=11;
                }
                else{
                    value += 1;
                }
            }
            else{
                value += c.getValue();
            }
        }
        return value;
    }
    static void sortHand(ArrayList<Card> a){
        for (int i=0; i<a.size();i++){
            int small = findSmall (a, i);
            swap (a, i, small);
        }
    }
    private static int findSmall (ArrayList<Card> a, int n){
        int small=n;
        for (int i=n+1; i<a.size(); i++){
            if (a.get(i).getValue()<a.get(small).getValue())
                small=i;
        }
        return small;
    }
    private static void swap (ArrayList<Card> a, int i, int j){
        Card x = (a.get(i));
        a.set(i, a.get(j));
        a.set(j, x);
    }

    public abstract int playHand(Deck deck);


}

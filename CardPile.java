/**
 * Representation of a card pile.  
 *. 
 */

import java.util.Random;
import java.util.ArrayList;


public class CardPile
{


   /** The collection of Cards */
   private ArrayList<Card> pile;
   
   /**
    * Constructs an empty card pile  
    */
   public CardPile()
   {
            pile = new ArrayList<Card>();
   }
   
    public CardPile(int numElements)
   {
            pile = new ArrayList<Card>(numElements);
   }

   
     /** 
     * Remove and return the top Card from the pile
     * @return A reference to a Card that was top on the pile
     */
   public Card dealCard()
   {
      Card c = pile.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   public void addCard(Card c)
   {
      pile.add(c);
   }   
      
   /** 
     * Return current number of Cards in pile
     * @return number of Cards in pile
     */

   public int cardsRemaining()
   {  
      return pile.size();
   }
   /** 
     * Randomize the order of Cards in pile
     */

   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < pile.size(); i++)
      {
         randNum = r.nextInt(pile.size());
         temp = pile.get(i);
         pile.set(i,pile.get(randNum));
         pile.set(randNum,temp);
      }      
   }
   /** 
     * Determine if pile is empty
     * @return true if there are no more cards, false otherwise
     */
   
   public boolean isEmpty()
   {
      return (pile.size() == 0);
   }

 
   public static Card highCard(Card...cards)
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}


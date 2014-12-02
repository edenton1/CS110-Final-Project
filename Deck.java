/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 */

import java.util.Random;
import java.util.ArrayList;


public class Deck extends CardPile
{
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
            super();
            freshDeck();
            
   }
   
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
         {
          
            Card card = new Card(r,s);
            super.addCard(card);
           
         }
      }
     
   
   }
}   
  
   
  
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
   
   public void shuffle()
   {
      super.shuffle();
   }
   
   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!deck.isEmpty())
         System.out.println(i++ + " : " + deck.dealCard().toString());
      System.out.println(deck.cardsRemaining());
      deck.freshDeck();
      while (!deck.isEmpty())
         System.out.println(i++ + " : " + deck.dealCard().toString());
         
      Card c1 = new Card(Card.ACE,Card.HEARTS);
      Card c2 = new Card(Card.JACK,Card.SPADES);
      Card c3 = new Card(4,Card.HEARTS);
      
      System.out.println(highCard(c1,c2,c3));
      

}
}
//Ellie Denton
//CS 110 Homework 5

/** This class represents a specific card from a standard 52 card deck */

public class Card
{
   //Initialize suits and face cards
   public static final int SPADES = 0; 
   public static final int CLUBS = 1;
   public static final int HEARTS = 2;
   public static final int DIAMONDS = 3;
   public static final int ACE = 1;
   public static final int JACK = 11;
   public static final int QUEEN = 12;
   public static final int KING = 13;
   public int rank;
   public int suit;

/** Constructor to create instance of card.
@param s is the suit
@param r is the rank */

public Card(int rank, int suit)
{
   this.rank = rank;
   this.suit = suit;

}


/** Return the suit
@return suit Is the suit represented by the card*/

public int getSuit()
{
   return suit;

}

/** Return the rank
@return rank Is the rank represented by the card*/

public int getRank()
{
   return rank;

}

/** String representation of object
@return Str Is the String represenation of the object*/

public String toString()
{
   String strSuit; // initialize string of suit
   String strRank; // initialize string of rank
  
   // Convert integer representations into descriptive output  
   if (suit == 1)
      {
         strSuit = "Spades"; 
      }
   else if (suit == 2)
      {
          strSuit = "Clubs";
      }
   else if (suit == 3)
      {
          strSuit = "Hearts";
      }
   else
      {
          strSuit = "Diamonds";
      }
      
   if (rank == 1)
      {
         strRank = "Ace";
      }
   else if (rank == 11)
      {
         strRank = "Jack";
      }
   else if (rank == 12)
      {
         strRank = "Queen";
      }
   else if (rank == 13)
      {
         strRank = "King";
      }
   else
      {
         strRank = Integer.toString(rank);
      }
   String str = strRank + " of " + strSuit;
   return str;
}
/** Check if two cards are equal. Cards are equal if their ranks are the same.
@return status Is true if the ranks are the same */

public boolean equals(Card c2)
{
   boolean status;
   if (this.rank == c2.getRank())
   {
     status = true;
   }
   else
   {
      status = false;
   }
   
   return status;
}




}
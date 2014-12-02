//Ellie Denton
//CS110

/**This class represents the card game War*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGame
{
   private CardPile player = new CardPile(); //initialize cardpile for the player
   private CardPile computer = new CardPile(); //initialize cardpile for the computer
   private CardPile warPile = new CardPile(); //initialize cardpile used for a tie
   private Card c; //computer's card played
   private Card p; //player's card played
   private ImageIcon cimage; //image associated with computer's card
   private ImageIcon pimage; //image associated with player's card
   private boolean winner; //flag to end game when there is a winner
   private CardPile handWinner; //winner of each hand
   private boolean war; //flag to mark a tie in the hand
   private Deck deck; //deck of cards

/**Constructor starts and instance of the game war*/
   public WarGame()
   {
      deal(); 
      war = false;   
   }

/**Method to shuffle the deck and deal the cards between players*/
   public void deal()
   {
      
    deck = new Deck();
    deck.shuffle();
    
    while (!deck.isEmpty())
    {
      computer.addCard(deck.dealCard());
      player.addCard(deck.dealCard());
    }       
       
   
   }
   
/**Method to play a single hand of the game*/   
   public void battle()
   {      
      if (!computer.isEmpty() && !player.isEmpty()) //check to make sure each player has a card to play
      {
         Card c = computer.dealCard(); 
         Card p = player.dealCard();
         
         setComputerImage(c);
         setPlayerImage(p);
         
         if (c.getRank() == p.getRank())//test cards for a tie
         {
            warPile.addCard(c);
            warPile.addCard(p);
            war = true;
            
         }
         else if (!warPile.isEmpty()) //add cards to war pile if there is a tie
            {
               if (c.getRank() > p.getRank())
                  {
                     while(!warPile.isEmpty())
                     {
                        computer.addCard(warPile.dealCard());
                     }   
                     
                     handWinner(c,p); 
                        
                  }
                  
                  else if (c.getRank() < p.getRank())
                  {
                      while(!warPile.isEmpty())
                     {
                        player.addCard(warPile.dealCard());
                     }   
                     
                     handWinner(c,p);                  
                  }

            }
            
            
            else
            {
               handWinner(c,p);
            }
         
      }
      else
      {
         gameWinner(); 
      }   
         
         
   }
   
/**Method to handle a tie*/   
   public void tie()
   {
        if (computer.isEmpty() || player.isEmpty())
        {
           gameWinner();
                            
        }
            
        else
        {
            warPile.addCard(computer.dealCard());
            warPile.addCard(player.dealCard());  
            war = false;
                
        }
  }
  
/**Return status if there is a tie
@return Returns true if the hand dealt a tie */
  public boolean getWar()
  {
      return war;
  }
       
/**Method to determine the winner of the hand
@param c Is the computer's card 
@param p is the player's card*/
   
   public void handWinner(Card c, Card p)
   {   
       handWinner = new CardPile();
       
       if(c.getRank() > p.getRank())
             {
               computer.addCard(c);
               computer.addCard(p);
               handWinner = computer;
             }
             
             else if (c.getRank() < p.getRank())
             {
               player.addCard(c);
               player.addCard(p);
               handWinner = player;
             }         
   }
   
/**Method to return the winner of the hand
@return Returns the cardpile of the winner of the hand*/
   public CardPile getHandWinner()
   {
      return handWinner;
   }
   
/**Method to return the card played by the computer
@return Returns the card played by the computer*/   
   public Card getComputerCard()
   {
      return c;
   }
 
/**Method to return the card played by the player
@return Returns the card played by the player*/   
   public Card getPlayerCard()
   {
      return p;
   }

/**Method to set the image of the card played by the computer
@param c Is the card played by the computer*/   
   public void setComputerImage(Card c)
   {
      cimage = c.getImage();
   }

/**Method to set the image of the card played by the player
@param p Is the card played by the player*/     
    public void setPlayerImage(Card p)
   {
      pimage = p.getImage();
   }

/**Method to get the image of the card played by the computer
@param c Is the card played by the computer*/     
   public ImageIcon getComputerImage()
   {
      
      return cimage ;
   }

/**Method to get the image of the card played by the player
@param p Is the card played by the player*/    
   public ImageIcon getPlayerImage()
   {
      
      return pimage ;
   }

/**Method to return string form of winner of the game
@return Returns the string form of the winner*/   
   public String gameWinner()
   {  
      String str;
      
        if (computer.isEmpty())
            {
               str = "Player Wins!";
            }
            
            else
            {
               str = "Computer Wins!";
            }
            
     return str;
   
   }

/**Method to determine if their is a winner
@return Returns true if there is a winner of the game*/   
   public Boolean winner()
   {
      boolean winner = false;
      if (computer.isEmpty() || player.isEmpty()) 
      {
         winner = true;
      }
      return winner;
   
   }

/**Method to return the number of cards in Computer's cardpile
@return Returns the # of cards remaining in the computer's cardpile as an integer*/   
   public int computerRem()
   {
      return computer.cardsRemaining();
   }

/**Method to return the number of cards in player's cardpile
@return Returns the # of cards remaining in the players's cardpile as an integer*/   
   public int playerRem()
   {
      return player.cardsRemaining();
   }



} 
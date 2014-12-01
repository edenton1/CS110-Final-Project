import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGame
{
   private CardPile player = new CardPile();
   private CardPile computer = new CardPile();
   private CardPile warPile = new CardPile();
   private Card c;
   private Card p;
   private ImageIcon cimage;
   private ImageIcon pimage;
   private boolean winner;
   private boolean war;
   private Deck deck;


   public WarGame()
   {
      deal();
      war = false;   
   }

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
   
   public void battle()
   {
      
      
      if (!computer.isEmpty() && !player.isEmpty())
      {
         Card c = computer.dealCard();
         Card p = player.dealCard();
         
         setComputerImage(c);
         setPlayerImage(p);
         
         if (c.getRank() == p.getRank())
         {
            warPile.addCard(c);
            warPile.addCard(p);
            war = true;
            // tie();
         }
         else if (!warPile.isEmpty())
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
  
  public boolean getWar()
  {
      return war;
  }
      
   
   
   
   public CardPile handWinner(Card c, Card p)
   {   
       CardPile winner = new CardPile();
       
       if(c.getRank() > p.getRank())
             {
               computer.addCard(c);
               computer.addCard(p);
               winner = computer;
             }
             
             else if (c.getRank() < p.getRank())
             {
               player.addCard(c);
               player.addCard(p);
               winner = player;
             }
      
      return winner;
         
   }
   
   public Card getComputerCard()
   {
      return c;
   }
   
   public Card getPlayerCard()
   {
      return p;
   }
   
   public void setComputerImage(Card c)
   {
      cimage = c.getImage();
   }
   
    public void setPlayerImage(Card p)
   {
      pimage = p.getImage();
   }
   
   public ImageIcon getComputerImage()
   {
      
      return cimage ;
   }
   
   public ImageIcon getPlayerImage()
   {
      
      return pimage ;
   }
   
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
   
   public Boolean winner()
   {
      boolean winner = false;
      if (computer.isEmpty() || player.isEmpty()) 
      {
         winner = true;
      }
      return winner;
   
   }
   
   public int computerRem()
   {
      return computer.cardsRemaining();
   }
   
   public int playerRem()
   {
      return player.cardsRemaining();
   }



} 
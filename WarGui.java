import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WarGui extends JFrame 
{
   private JPanel panel;
   private JButton buttonBattle;
   private JLabel computerCard;
   private JLabel playerCard;
   private ImageIcon back;
 //   private CardPile player = new CardPile();
//    private CardPile computer = new CardPile();
   public final static int ONE_SECOND = 5000;
   private Timer timer;
   // private CardPile warPile = new CardPile();
   
   
   public WarGui(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      buttonBattle = new JButton("Battle");
      panel.add(buttonBattle);
      buttonBattle.addActionListener(new ButtonListener());
      back = new ImageIcon("back.jpg");
          
      add(panel);
      
     
      
      computerCard = new JLabel("Computer:" + computer.cardsRemaining(), back, JLabel.RIGHT);
      playerCard =new JLabel("Player:" + player.cardsRemaining(), back, JLabel.LEFT);
      computerCard.setPreferredSize(new Dimension(152, 250));
      playerCard.setPreferredSize(new Dimension(152, 250));
      computerCard.setVerticalTextPosition(JLabel.TOP);
      playerCard.setVerticalTextPosition(JLabel.TOP);
      computerCard.setHorizontalTextPosition(JLabel.CENTER);
      playerCard.setHorizontalTextPosition(JLabel.CENTER);
      panel.add(computerCard);
      panel.add(playerCard);

      
      
            

     
   }
   // private inner class
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
                 
      
         if (!computer.isEmpty() && !player.isEmpty())
         {
            int compSize = computer.cardsRemaining();
            int playerSize = player.cardsRemaining();
            Card c = computer.dealCard();
            Card p = player.dealCard();
            
            computerCard.setIcon(c.getImage());
            playerCard.setIcon(p.getImage());
            
            
            if (c.getRank() == p.getRank())
            {  
               Boolean war = true;
               
               timer = new Timer(ONE_SECOND, new ActionListener() 
                  {
                     public void actionPerformed(ActionEvent evt) 
                     { 
                        computerCard.setIcon(back);
                        playerCard.setIcon(back);
                     }
               
                  });
                  
                  timer.start();
                  

               
               while(war && (computer.cardsRemaining()!=0 || player.cardsRemaining()!=0))
               {
                                                 
                  warPile.addCard(computer.dealCard());
                  warPile.addCard(player.dealCard());
                  
                  c = computer.dealCard();
                  p = player.dealCard();
                  
                   
                  
                timer.start();
                  
                  computerCard.setIcon(c.getImage());
                  playerCard.setIcon(p.getImage());
                  
                  warPile.addCard(c);
                  warPile.addCard(p);
                  
                  

                  
                  if (c.getRank() > p.getRank())
                  {
                     while(!warPile.isEmpty())
                     {
                        computer.addCard(warPile.dealCard());
                     }   
                        war = false;
                  }
                  
                  else if (c.getRank() < p.getRank())
                  {
                      while(!warPile.isEmpty())
                     {
                        player.addCard(warPile.dealCard());
                     }   
                        war = false;                  
                  }
                  
                  
              
               }
               
             }
             
             else if(c.getRank() > p.getRank())
             {
               computer.addCard(c);
               computer.addCard(p);
             }
             
             else if (c.getRank() < p.getRank())
             {
               player.addCard(c);
               player.addCard(p);
             }
         
             computerCard.setText("Computer:" + computer.cardsRemaining());
             playerCard.setText("Player:" + player.cardsRemaining());
         
         
         }
         
         else
         {
            if (computer.isEmpty())
            {
               playerCard.setText("Player Wins!");
               computerCard.setText("Computer loses");
            }
            
            else
            {
               playerCard.setText("Player loses");
               computerCard.setText("Computer Wins!");
            }
         
         }
         
                 
      
      }
      
    }

 public static void main(String [] args)
   {
      
      
      JFrame frame = new WarGui("Game of War");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
  
   }
   
}
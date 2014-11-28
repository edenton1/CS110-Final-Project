import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WarGui extends JFrame 
{
   private JPanel panel;
   private JButton buttonBattle;
   private JLabel computerCard;
   private JLabel playerCard;
   private ImageIcon playerCardImage;
   private ImageIcon computerCardImage;
   private ImageIcon back;
   
   public WarGui(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      buttonBattle = new JButton("Battle");
      panel.add(buttonBattle);
      buttonBattle.addActionListener(new ButtonListener());
      playerCardImage = new ImageIcon("aces.jpg");
      computerCardImage = new ImageIcon("2c.jpg");
      back = new ImageIcon("back.jpg");
      
      
      JLabel computerCard = new JLabel(back);
      JLabel playerCard =new JLabel(back);
      
      // panel.add(computerCard);
      panel.add(playerCard);
      
      
      
      add(panel);
        
      // add(buttonBattle);
      add(computerCard);
//       add(playerCard);
     
   }
   // private inner class
   class ButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e) 
      {
         
         computerCard.setIcon(computerCardImage);
         
         playerCard.setIcon(playerCardImage);
         
         
      }
      
    }

 public static void main(String [] args)
   {
      CardPile player = new CardPile();
      CardPile computer = new CardPile();
      for(int i = 1; i<=3; i++)
      {
         for (int j = 3; j>0; j--)
         {
            Card c = new Card(i, j);
            player.addCard(c);
            Card c2 = new Card(j, i);
            computer.addCard(c2);
         }
      }
      
      JFrame frame = new WarGui("Game of War");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
  
   }
   
}
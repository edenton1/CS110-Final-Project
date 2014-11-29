import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WarGui2 extends JFrame 
{
   private WarGame game;
   private JPanel panel;
   private JButton buttonBattle;
   private JLabel computerCard;
   private JLabel playerCard;
   private ImageIcon back;
 //   private CardPile player = new CardPile();
//    private CardPile computer = new CardPile();
   public final static int ONE_SECOND = 5000;
   private Timer timer;
   boolean winner;
   // private CardPile warPile = new CardPile();
   
   
   public WarGui2(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      buttonBattle = new JButton("Battle");
      panel.add(buttonBattle);
      buttonBattle.addActionListener(new ButtonListener());
      back = new ImageIcon("back.jpg");
          
      add(panel);
      
      game = new WarGame();
      
     
      
      computerCard = new JLabel("Computer", back, JLabel.RIGHT);
      playerCard =new JLabel("Player", back, JLabel.LEFT);
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
         winner = game.winner();
         if (winner)
         {
            computerCard.setText(game.gameWinner());
            playerCard.setText(game.gameWinner());
         }
         else
         {
         game.battle();
         computerCard.setIcon(game.getComputerImage());
         playerCard.setIcon(game.getPlayerImage());
         computerCard.setText("Computer:" + game.computerRem());
         playerCard.setText("Player:" + game.playerRem());

         }
        
      
      
      
      }
      
      
   }








 public static void main(String [] args)
   {
      
      
      JFrame frame = new WarGui2("Game of War");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
  
   }
   
   }
   

      
      
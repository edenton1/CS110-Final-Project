//Ellie Denton
//CS110
/**GUI to implement card game war*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class WarGui2 extends JFrame 
{
   private WarGame game; //initialize game of War
   private JPanel panel; //initialize panel for GUI
   private JButton buttonBattle; //initialize button for GUI
   private JLabel computerCard; //label to display image of computer card
   private JLabel playerCard; //label to display image of player card
   private ImageIcon back; //image for back of card
   boolean winner; //flag if there is a winner
 
/**Constructor of GUI*/   
   public WarGui2()
   {  
      super("Game of War");

      // set up a new panel in the frame
      panel = new JPanel();
      //Create button to play each hand
      buttonBattle = new JButton("Battle");
      //add button to the panel
      panel.add(buttonBattle);
      //create action for button
      buttonBattle.addActionListener(new ButtonListener());
      //create image icon for back of the card
      back = new ImageIcon("back.jpg");
      //add panel to window    
      add(panel);
      //create instance of war game
      game = new WarGame();
      
      //label to represent computer and card
      computerCard = new JLabel("Computer", back, JLabel.RIGHT);
      //label to represent player and card
      playerCard =new JLabel("Player", back, JLabel.LEFT);
      //set size of label
      computerCard.setPreferredSize(new Dimension(152, 250));
      //set size of label
      playerCard.setPreferredSize(new Dimension(152, 250));
      //set text position in label
      computerCard.setVerticalTextPosition(JLabel.TOP);
      //set text position
      playerCard.setVerticalTextPosition(JLabel.TOP);
      //set text position
      computerCard.setHorizontalTextPosition(JLabel.CENTER);
      //set text position in label
      playerCard.setHorizontalTextPosition(JLabel.CENTER);
      //add labels to panel
      panel.add(computerCard);
      panel.add(playerCard);
      
      }
      
   // private inner class 
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         winner = game.winner(); //check if there is a winner
         
         if (winner) //if there is a winner, display who won in the labels
         {
            computerCard.setText(game.gameWinner());
            playerCard.setText(game.gameWinner());
         }
         
         else if (!game.getWar()) //If there is not a tie in the hand
         {
            game.battle(); //play a hand
            computerCard.setIcon(game.getComputerImage()); //set image for labels
            playerCard.setIcon(game.getPlayerImage());
            computerCard.setText("Computer:" + game.computerRem()); //display # of cards remaining in for each player
            playerCard.setText("Player:" + game.playerRem());

         }
         
         else if (game.getWar()) //if there is a tie in the hand
         {
            game.tie(); //tie breaker
            computerCard.setIcon(back); //display back of card
            playerCard.setIcon(back);  // display back of card
            computerCard.setText("Computer:" + game.computerRem()); //update # of cards remaining in for each player
            playerCard.setText("Player:" + game.playerRem());

         }
             
      }
      
 }

 public static void main(String [] args)
   {
      JFrame frame = new WarGui2();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
   
   }
   

      
      
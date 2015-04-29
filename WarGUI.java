//Nathan Callas
//war gui

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel,bottomPanel;
   private JButton playerButton, war1, war2;
   private ImageIcon cardBack;
   private JLabel status,playerDeck,computerDeck, title, roundWinner;
   private char action;
   // build the GUI
   public WarGUI()
   {
   
   action='a';
   setLayout(new GridLayout(2,1));
      // create game instance
      game =new War();
      
      //define the top panel
   topPanel = new JPanel();
      topPanel.setBackground(Color.green);
      
      //define the bottom panel
   bottomPanel= new JPanel();
      bottomPanel.setBackground(Color.white);
   
   //load card backs and buttons onto panels
   cardBack=new ImageIcon("back.jpg");
   String buttonText="click";
   playerButton= new JButton(buttonText);
   
   topPanel.add(playerButton);
   title=new JLabel("A game of war");
   title.setFont(new Font("ARIAL",Font.BOLD,36));
   topPanel.add(title);
      
   add(topPanel);
   
   //add war buttons to panels
   war1=new JButton(cardBack);
   war2=new JButton(cardBack);
   
   bottomPanel.add(war1);
   
   playerDeck=new JLabel("Player");
   bottomPanel.add(playerDeck);
   
   bottomPanel.add(war2);
   computerDeck=new JLabel("Computer");
   bottomPanel.add(computerDeck);
   add(bottomPanel);
   game.deal();
   playerButton.addActionListener(new ButtonListener());
   
   }
   
   
   // handle button events
   private class ButtonListener implements ActionListener
   {
      private String fightWinner;
      private char roundWinnerTrigger='a';
      public void actionPerformed(ActionEvent e)
      {  
         
         if (action=='a')
         {
            //start new fight
            game.reveal();
            
            //get the cards being used in the fight
            Card playerUp=new Card(game.getPlayerCard());
            Card computerUp=new Card(game.getComputerCard());
            
            //load images into buttons
            ImageIcon playerImage=new ImageIcon();
            playerImage=playerUp.getImage();
            ImageIcon computerImage=new ImageIcon();
            computerImage=computerUp.getImage();
            
            war1.setIcon(playerImage);
            war2.setIcon(computerImage);
            action='b';
         }
         
         if (action=='b')
         {
            //compare cards
            game.fight();
            
            //find out who won
            String fightWinner = game.getFightWinner();
            
            //say who won the round
            if (roundWinnerTrigger=='b')
            {
               topPanel.remove(roundWinner);
            }
            roundWinner=new JLabel();
            roundWinner.setFont(new Font("ARIAL",Font.BOLD,16));
            topPanel.add(roundWinner);
            roundWinner.setText(fightWinner+" won the round");
            roundWinnerTrigger='b';
         }
        
        //say who won the game
        if (game.getWinner().equals("player"))
        {
            JLabel status = new JLabel("Player won the game");
            status.setFont(new Font("ARIAL",Font.BOLD,24));
            topPanel.add(status);
        }
        
        if (game.getWinner().equals("computer"))
        {
            JLabel status = new JLabel("Computer won the game");
            status.setFont(new Font("ARIAL",Font.BOLD,24));
            topPanel.add(status);
        }   
         
      }
      

   }
   
}
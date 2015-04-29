//Nathan Callas
//War game
//no interface

public class War
{

   private Deck deck, player, computer;
   private String winner, fightWinner;
   private Card playerCard, computerCard, playerCard2, computerCard2, playerCard3, computerCard3;
   
   /**
   sets up players and computers decks of cards and deals them out to the player and the computer
   */
   public void deal()
   {
      deck=new Deck();
      player=new Deck(600);
      computer=new Deck(600);
      deck.shuffle();
      
      //deal to player
      for(int i=0;i<26;i++)
      {
         Card dealtCard=deck.dealCard();
         player.addCard(dealtCard);
      }
      
      //deal to computer
      for(int i=0;i<26;i++)
      {
         Card dealtCard=deck.dealCard();
         computer.addCard(dealtCard);
      }
      winner="none";
   }
   
   /**reveal top card of each deck and prepare for fighting*/
   public void reveal()
   {
      checkEmpty();
      playerCard=new Card(player.dealCard());
      computerCard=new Card(computer.dealCard());
   }
   
   /**each deck "fights"*/
   public void fight()
   {
      
      
      int compared=playerCard.compareTo(computerCard);
      if (compared==1)
      {  
         checkEmpty();
         if (!player.isEmpty())
         {
            if (!computer.isEmpty())
            {
               player.addCard(playerCard);
               player.addCard(computerCard);
               player.shuffle();
               fightWinner="Player";
            }
            else
            {
               winner="Player";
            }
         }
         else
         {
            winner="Computer";
         }
      }
      
      if (compared==-1)
      {
         checkEmpty();
         if (!player.isEmpty())
         {
            if (!computer.isEmpty())
            {
               computer.addCard(computerCard);
               computer.addCard(playerCard);
               computer.shuffle();
               fightWinner="Computer";
            }
            else
            {
               winner="Player";
            }
         }
         else
         {
            winner="Computer";
         }
      }
      
      if (compared==0)
      {
         checkEmpty();
         int uhoh=war(playerCard,computerCard);
      }
   }
   
   /**discover if a deck is empty or not.  If a deck is empty, declare a winner and exit the program.*/
   public void checkEmpty()
   {
      if (player.isEmpty())
      {
         winner="Computer";
         System.exit(0);
      }
      
      if (computer.isEmpty())
      {
         winner="Player";
         System.exit(0);
      }
   }
   
   /**fight a war
   @param a the player's card
   @param b the computer's card
   @return the number found when comparing the final card, used in the fight method to re-compare the first two cards
   */
   public int war(Card a, Card b)
   {
      Card playerCard2=player.dealCard();
      Card computerCard2=computer.dealCard();
      checkEmpty();
      
      Card playerCard3=player.dealCard();
      Card computerCard3=computer.dealCard();
      checkEmpty();
      
      int compared2=playerCard3.compareTo(computerCard3);
      if (compared2==0)
      {
         compared2=war(playerCard3, computerCard3);
      }
      if (compared2==1)
      {
         player.addCard(a);
         player.addCard(b);
         player.addCard(playerCard2);
         player.addCard(computerCard2);
         player.addCard(playerCard3);
         player.addCard(computerCard3);
         player.shuffle();
         
      }
      if (compared2==-1)
      {
         computer.addCard(computerCard);
         computer.addCard(playerCard);
         computer.addCard(computerCard2);
         computer.addCard(playerCard2);
         computer.addCard(computerCard3);
         computer.addCard(playerCard3);
         computer.shuffle();
      }
      
      return compared2;
   }
   
   /**get the player's card
   @return player's card
   */
   public Card getPlayerCard()
   {
      return playerCard;
   }
   
   /**get the computer's card
   @return computer's card
   */
   public Card getComputerCard()
   {
      return computerCard;
   }
   
   public Card getPlayerCard2()
   {
      return playerCard2;
   }
   
   public Card getComputerCard2()
   {
      return computerCard2;
   }
   
   public Card getPlayerCard3()
   {
      return playerCard3;
   }
   
   public Card getComputerCard3()
   {
      return computerCard3;
   }
   
   /**get winner of fight
   @return the winner of the fight
   */
   public String getFightWinner()
   {
      return fightWinner;
   }
   
   /**get winner of the game
   @return the winner of the game
   */
   public String getWinner()
   {
      return winner;
   }
}
//modified deck class given on blackboard

import java.util.Random;
import javax.swing.ImageIcon;
public class Deck 
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   public final static int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   private Card [] deck;
   /** Current number of Cards in Deck */
   private int ct;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
      freshDeck();
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      deck = new Card[CARDS_IN_DECK];
      for (int r = Card.SPADE; r<=Card.CLUB;r++)
      {
         for (int s=2;s<=14;s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      }
      
      //add images to cards
      deck[0].giveImage("2s.jpg");
      deck[1].giveImage("3s.jpg");
      deck[2].giveImage("4s.jpg");
      deck[3].giveImage("5s.jpg");
      deck[4].giveImage("6s.jpg");
      deck[5].giveImage("7s.jpg");
      deck[6].giveImage("8s.jpg");
      deck[7].giveImage("9s.jpg");
      deck[8].giveImage("10s.jpg");
      deck[9].giveImage("jacks.jpg");
      deck[10].giveImage("queens.jpg");
      deck[11].giveImage("kings.jpg");
      deck[12].giveImage("aces.jpg");
      deck[13].giveImage("2h.jpg");
      deck[14].giveImage("3h.jpg");
      deck[15].giveImage("4h.jpg");
      deck[16].giveImage("5h.jpg");
      deck[17].giveImage("6h.jpg");
      deck[18].giveImage("7h.jpg");
      deck[19].giveImage("8h.jpg");
      deck[20].giveImage("9h.jpg");
      deck[21].giveImage("10h.jpg");
      deck[22].giveImage("jackh.jpg");
      deck[23].giveImage("queenh.jpg");
      deck[24].giveImage("kingh.jpg");
      deck[25].giveImage("aceh.jpg");
      deck[26].giveImage("2d.jpg");
      deck[27].giveImage("3d.jpg");
      deck[28].giveImage("4d.jpg");
      deck[29].giveImage("5d.jpg");
      deck[30].giveImage("6d.jpg");
      deck[31].giveImage("7d.jpg");
      deck[32].giveImage("8d.jpg");
      deck[33].giveImage("9d.jpg");
      deck[34].giveImage("10d.jpg");
      deck[35].giveImage("jackd.jpg");
      deck[36].giveImage("queend.jpg");
      deck[37].giveImage("kingd.jpg");
      deck[38].giveImage("aced.jpg");
      deck[39].giveImage("2c.jpg");
      deck[40].giveImage("3c.jpg");
      deck[41].giveImage("4c.jpg");
      deck[42].giveImage("5c.jpg");
      deck[43].giveImage("6c.jpg");
      deck[44].giveImage("7c.jpg");
      deck[45].giveImage("8c.jpg");
      deck[46].giveImage("9c.jpg");
      deck[47].giveImage("10c.jpg");
      deck[48].giveImage("jackc.jpg");
      deck[49].giveImage("queenc.jpg");
      deck[50].giveImage("kingc.jpg");
      deck[51].giveImage("acec.jpg");
   }
   
   /**
    * Constructs a deck of a different size
    * @given the number of cards in the created deck
    */
   public Deck(int given)
   {
      deck=new Card[given];
   }
   
   
   /**
    * Adds a card to a deck
    * @given the card given
    */
   public void addCard(Card given)
   {
      deck[ct]=new Card(given);
      ct=ct+1;
   }
    
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
            ct--;

      return deck[ct];
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining()
   {  
      return ct;
   }
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
}

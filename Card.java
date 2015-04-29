//Nathan Callas
//card class
import javax.swing.ImageIcon;
public class Card
{

   /**
   value assigned to the spade suit
   */
   public static final int SPADE=1;
   
   /**
   value assigned to the heart suit
   */
   public static final int HEART=2;
   
   /**
   value assigned to the diamond suit
   */
   public static final int DIAMOND=3;
   
   /**
   value assigned to the club suit
   */
   public static final int CLUB=4;
   public static final int ACE=14;
   public static final int JACK=11;
   public static final int QUEEN=12;
   public static final int KING=13;
   
   private int rank, suit;
   private ImageIcon image;
   
      /**
       * default constructor
       * @param givenSuit the suit of the card created
       * @param givenRank the rank of the card created
       */
     public Card(int givenSuit, int givenRank)
     {
      suit=givenSuit;
      rank=givenRank;
     }
     
     /**
      *copy constructor
      *@param given the card being copied
     */
     public Card(Card given)
     {
      suit=given.getSuit();
      rank=given.getRank();
     }
     
     /** get the suit of the card
     @return the suit of the card*/
     public int getSuit()
     {
      return suit;
     }
     
     /** get the rank of the card
     @return the rank of the card*/
     public int getRank()
     {
      return rank;
     }
     
     /** get the rank of the card as a string
     @return the rank of the card as a string*/
     public String getRankString()
     {
     
      if (rank<11)
      {
         return String.valueOf(rank);
      }
      
      else if (rank==11)
      {
         return "Jack";
      }
      else if (rank==12)
      { 
         return "Queen";
      }
      else if (rank==13)
      {
         return "King";
      }
      else if (rank==14)
      {
         return "Ace";
      }
      else
      {
         return "Invalid Rank";
      }
     }
     
     /**get the name of the card as a string
     @return the name of the card*/
     public String toString()
     {
     if (suit==SPADE)
      return this.getRankString()+" of spades";
     
     if (suit==HEART)
      return this.getRankString()+" of hearts";
     
     if (suit==CLUB)
      return this.getRankString()+" of clubs";
     
     if (suit==DIAMOND)
      return this.getRankString()+" of diamonds";
      
     else
      return "Invalid suit";
     }
     
     /**true if a card equals another card, false otherwise
     @return the equality of two cards
     @param given the card being compared to this card*/
     public boolean equals(Card given)
     {
      if (given.rank==this.rank)
         return true;
      else
         return false;
     }
     /**compares value of card to a given card:-1 if this card is lower, 0 if equal, 1 if this card is higher
     @return the relative value of 2 cards
     @param given the card being compared to this card*/
     public int compareTo(Card given)
     {
     if (this.rank<given.rank)
         return -1;
     if (this.rank==given.rank)
         return 0;
     else
         return 1;
     }
     
     /**give image icon to card
     @param given the name of the card*/
     public void giveImage(String given)
     {
      image=new ImageIcon(given);
     }
     
     /**get image icon from card
     @return the image associated with the card*/
     public ImageIcon getImage()
     {
      return image;
     }
     
     /**get name of image of card
     @return the name of the image associated with the card*/
     public String getImageName()
     {
      String imageName=image.toString();
      return imageName;
     }
}
//WarGUIDriver

import javax.swing.*;

public class WarGUIDriver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500,500);
      frame.validate();
      frame.setVisible(true);


   
   
   }


}
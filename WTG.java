
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
//import sparseMatrix.Commander;
//import sparseMatrix.Card;
//import sparseMatrix.sparseMatrix;
import java.io.*;

public class WTG

{

   public static sparseMatrix<Card> sm = new sparseMatrix<Card>(5, 11);
   public static ArrayList<Card> deck0 = new ArrayList();
   public static ArrayList<Card> deck1 = new ArrayList();
   public static ArrayList<Card> hand0 = new ArrayList();
   public static ArrayList<Card> hand1 = new ArrayList();
   public static ArrayList<Card> discard0 = new ArrayList();
   public static ArrayList<Card> discard1 = new ArrayList();
   public static ArrayList<Card> exile0 = new ArrayList();
   public static ArrayList<Card> exile1 = new ArrayList();
   public static int turnNum0 = 1;
   public static int turnNum1 = 1;
   public static int manaCrystal0 = 1;
   public static int manaCrystal1 = 0;



   public static void main(String[] vidyagame) throws IOException {
   
   	// drawCardFromDiscard(byte playerNum, ArrayList<Card> discard)
   	// discard((byte) 0, hand0, discard0);
   	// drawCardFromDiscard((byte) 0, discard0);
   	
   
      sm.add(2, 1, new Commander((byte) 0));
      sm.add(2, 9, new Commander((byte) 1));
   
      Scanner anime = new Scanner(new FileReader("cards.txt"));
      while (anime.hasNextLine()) {
      
         deck0.add(new Card(anime.nextLine()));
      }
      anime.close();
   
      Scanner season2 = new Scanner(new FileReader("cards2.txt"));
      while (season2.hasNextLine()) {
      
         deck1.add(new Card(season2.nextLine()));
      }
      season2.close();
   
   	// byte setPlayer = 0;
   
   	// double d = Math.random();
   	// if (d < 0.5)
   
      drawCard((byte) 0);
      drawCard((byte) 0);
      drawCard((byte) 0);
   
      drawCard((byte) 1);
      drawCard((byte) 1);
      drawCard((byte) 1);
      drawCard((byte) 1);
   
      Card c0 = findCommander((byte) 0);
      Card c1 = findCommander((byte) 1);
   
      while (c0.getHealth() > 0 && c1.getHealth() > 0) {
      
         standbyPhase();
         mainPhase((byte) 0);
         
         standbyPhase();
         mainPhase((byte) 1);         
      	
      
         System.out.println(deck0);
         System.out.println(deck1);
      
               
      }
      if (c1.getHealth() == 0) {
         System.out.println("player 1 has won");
      } 
      else
      
         System.out.println("player 2 has won");
   
   }

   public static Scanner input = new Scanner(System.in);

   public static Card findCommander(byte playerNum) {
      for (int r = 0; r < sm.numRows(); r++) {
         for (int c = 0; c < sm.numColumns(); c++) {
            Card temp = sm.get(r, c);
            if (temp != null && temp instanceof Commander && temp.getPlayer() == playerNum)
               return temp;
         }
      }
      return null;
   }

   public static void standbyPhase() {
   
      Card c0 = findCommander((byte) 0);
      Card c1 = findCommander((byte) 1);
   
      System.out.println("health of commander " + c0.getHealth());
      System.out.println("health of commander " + c1.getHealth());
   
      showToScreen();
      showStats();
   
      System.out.println("");
   
   }

   public static void mainPhase(byte playerNum)
   
   {
      
           
      if (playerNum == 0) {
      
         byte count = 0;
      
         System.out.println("player's turn " + playerNum);
         System.out.println("turn number " +  turnNum0);
         System.out.println("mana crystals " +  manaCrystal0);
      
         System.out.println("choose an option from the menu");
         System.out.println("1: play a card");
         System.out.println("2: show target stats");
         System.out.println("3: goto battle phase");
         System.out.println("8: end turn");
         playerNum = 1;
         
         byte input2 = (byte) (input.nextInt());
      
         while (input2 < 7 && input2 > 0) {
            if (input2 == 1) {
               playCard((byte) 0, hand0);
            }
            if (input2 == 2) {
            
               showTargetStats((byte) 0, hand0);
            
            }
            if (input2 == 3) {
            
               battlePhase();
            
            }
            if (input2 == 4) {
            
            
            
            }
         
            for(int i = 0; i <= count; i++)
            {
            
               {
                  if(turnNum0 != 8)
                  {        
                     turnNum0++;
                  }
               
                  if(manaCrystal0 != 8)
                  { 
                     manaCrystal0++;
                  }
               }          
            }
         
            
            
         
            System.out.println("player's turn " + playerNum);
            System.out.println("turn number " +  turnNum0);
            System.out.println("mana crystals " +  manaCrystal0);
         
         
         
            System.out.println("choose an option from the menu");
            System.out.println("1: play a card");
            System.out.println("2: show target stats");
            System.out.println("3: goto battle phase");
            System.out.println("8: end turn");
            input2 = (byte) (input.nextInt());
            playerNum = 1;
            count++;
         
         }
      
         if (playerNum == 1) {
         
         
            System.out.println("player's turn " + playerNum);
            System.out.println("turn number " +  turnNum0);
            System.out.println("mana crystals " +  manaCrystal0);
             
         }
         
         System.out.println("choose an option from the menu");
         System.out.println("1: play a card");
         System.out.println("2: show target stats");
         System.out.println("3: goto battle phase");
         System.out.println("8: end turn");
         playerNum = 0;
         
            
         byte input3 = (byte) (input.nextInt());
         
         while (input3 < 7 && input3 > 0) {
            if (input3 == 1) {
               playCard((byte) 1, hand1);
            }
            if (input3 == 2) {
               
               showTargetStats((byte) 1, hand1);
               
            }
            if (input3 == 3) {
               
               battlePhase();
               
            }
            if (input3 == 4) {
                              	
            }
            	
            for(int i = 0; i <= count; i++)
            {
            
               {
                  if(turnNum0 != 8)
                  {        
                     turnNum0++;
                  }
               
                  if(manaCrystal0 != 8)
                  { 
                     manaCrystal0++;
                  }
               }          
            }
         
               
               
            System.out.println("player's turn " + playerNum);					
            System.out.println("turn number " +  turnNum0);
            System.out.println("mana crystals " +  manaCrystal0);
         
            
            
            System.out.println("choose an option from the menu");
            System.out.println("1: play a card");
            System.out.println("2: show target stats");
            System.out.println("3: goto battle phase");
            System.out.println("8: end turn");
            input2 = (byte) (input.nextInt());
            playerNum = 0;
            count++;
         
                         
            
         }
      }
   
   }

   public static void battlePhase() {
   
      sm.add(3, 2, new Commander((byte) 1));
   
      showToScreen();
   
      System.out.println("you want to attack with ");
      System.out.println("x coord");
      byte xCoord2 = (byte) (input.nextInt());
      System.out.println("y coord");
      byte yCoord2 = (byte) (input.nextInt());
   
      dealBattleDamage(xCoord2, yCoord2);
   
   }

   public static void showTargetStats(byte playerNum, ArrayList<Card> hand) {
      System.out.println("hand or field");
      String value3 = (input.nextLine());
      if (value3.equals("")) {
         value3 = (input.nextLine());
      }
      if (value3.equals("hand")) {
         if (playerNum == 0) {
            for (int r = 0; r < hand.size(); r++) {
            
               {
                  Card temp = hand.get(r);
                  System.out.print(hand.get(r) + " ");
                  System.out.print(r + " ");
                  System.out.println("card's health " + temp.getAtk());
                  System.out.println("card's attack " + temp.getHealth());
               
               }
            }
         } 
         else {
         
            System.out.println("choose the card you want to examine ");
            byte value2 = (byte) (input.nextInt());
         
            System.out.println("x coord");
            byte xCoord = (byte) (input.nextInt());
            System.out.println("y coord");
            byte yCoord = (byte) (input.nextInt());
         
            while (sm.get(xCoord, yCoord) != null) {
               System.out.println("the selected input is bad");
               System.out.println("player num " + playerNum);
            
               for (int r = 0; r < hand.size(); r++) {
               
                  {
                     System.out.println(hand.get(r).getName() + " ");
                     System.out.print("hand loc " + r);
                  
                  
                     System.out.println(" mc " + hand.get(r).getManacost() + " ");
                  }
               
               }
            
               System.out.println("");
               showToScreen();
            
               System.out.println("choose the card you want to play ");
               value2 = (byte) (input.nextInt());
               System.out.println("x coord");
               xCoord = (byte) (input.nextInt());
               System.out.println("y coord");
               yCoord = (byte) (input.nextInt());
            }
         
            Card temp = sm.get(xCoord, yCoord);
            System.out.print(temp);
            System.out.print(" " + temp.getPlayer());
            System.out.println("card's health " + temp.getAtk());
            System.out.println("card's attack " + temp.getHealth());
         
         }
      } 
      else {
      
         showStats();
      
      }
   
      System.out.println();
   }

   public static void playCard(byte playerNum, ArrayList<Card> hand) {
   
   
   
      System.out.println("player num " + playerNum);
      if(playerNum == 0)
      {
         System.out.println("avalible  mana crystals " +  manaCrystal0);
            
      }    
            
      else
      {
            
         System.out.println("avalible  mana crystals " +  manaCrystal1);
      
            
      }      
   
      
      
      System.out.println("number card in hand");
   
      showToScreen();
   
      for (int r = 0; r < hand.size(); r++) {
      
         {
            System.out.println(hand.get(r).getName() + " ");
            System.out.print("hand loc " + r);
            
          
            System.out.println(" mc " + hand.get(r).getManacost() + " ");
         
         }
      
      }
   
      System.out.println();
      if (hand.size() != 0 && ( (playerNum == 0 && manaCrystal0 != 0) ||  (playerNum == 1 && manaCrystal1 != 0) )) 
      
      {
      
         System.out.println("choose the card you want to play ");
         byte value2 = (byte) (input.nextInt());
         System.out.println("x coord");
         byte xCoord = (byte) (input.nextInt());
         System.out.println("y coord");
         byte yCoord = (byte) (input.nextInt());
         
                 
                
                 
         while (validInputToPlay(xCoord, yCoord, value2, hand, playerNum) == false) {
            System.out.println("the selected input is bad, or you dont have enough mana crystals to play that");
            System.out.println("player num " + playerNum);
                       
            if(playerNum == 0)
            {
               System.out.println("avalible  mana crystals " +  manaCrystal0);
            
            }    
            
            else
            {
            
               System.out.println("avalible  mana crystals " +  manaCrystal1);
            
            
            }      
                       
         
            
            
         
            for (int r = 0; r < hand.size(); r++) {
            
               {
                  System.out.println(hand.get(r).getName() + " ");
                  System.out.print("hand loc " + r);
               
               
                  System.out.println(" mc " + hand.get(r).getManacost() + " ");
               
               }
            
            }
         
            System.out.println("");
            showToScreen();
         
            System.out.println("choose the card you want to play ");
            value2 = (byte) (input.nextInt());
            System.out.println("x coord");
            xCoord = (byte) (input.nextInt());
            System.out.println("y coord");
            yCoord = (byte) (input.nextInt());
         }
      
         Card card = hand.get(value2);
         hand.remove(card);
      
         sm.add(xCoord, yCoord, card);
         if (card.getBattlecry() == 1) {
         
            System.out.println("what is the location of the card you want to deal battle damage to");
            System.out.println("x coord");
            byte x = (byte) (input.nextInt());
            System.out.println("y coord");
            byte y = (byte) (input.nextInt());
         
         	// dealDamage(x, y);
         
         }
         if (card.getBattlecry() == 2) {
         
         }
         System.out.println("(" + xCoord + "," + yCoord + ")");
         showToScreen();
      
      
         removeMana(playerNum, (byte)card.getManacost());
      
               
         
      
      
      
      
      }
         
                
   
   }

   public static byte removeMana(byte playerNum ,byte manaCost)
   {
   
      if (playerNum == 0) 
      
      
         manaCrystal0 =- manaCost;
      
      
      
      else
      
      
         manaCrystal1 =- manaCost;
   
   
   
      return manaCost;
   
   }


   public static byte playCardFromDiscard(byte playerNum, ArrayList<Card> discard) {
   
      System.out.println("number card in discardPile");
   
      for (int r = 0; r < discard.size(); r++) {
      
         {
            System.out.println(discard.get(r).getName() + " ");
            System.out.print("hand loc " + r);
            
          
            System.out.println(" mc " + discard.get(r).getManacost() + " ");
         
         
         }
      
      }
   
      System.out.println();
   
      System.out.println("choose the card you want to play from the discard pile ");
      byte value2 = (byte) (input.nextInt());
      System.out.println("x coord");
      byte xCoord = (byte) (input.nextInt());
      System.out.println("y coord");
      byte yCoord = (byte) (input.nextInt());
      while (validInputToPlay(xCoord, yCoord, value2, discard, playerNum) == false) {
         System.out.println("the selected input is bad");
      
         for (int r = 0; r < discard.size(); r++) {
         
            {
               System.out.print(discard.get(r) + " ");
               System.out.print(r + " ");
            }
         
         }
      
         System.out.println("");
         showToScreen();
      
         System.out.println("choose the card you want to play ");
         value2 = (byte) (input.nextInt());
         System.out.println("x coord");
         xCoord = (byte) (input.nextInt());
         System.out.println("y coord");
         yCoord = (byte) (input.nextInt());
      }
   
      Card card = discard.get(value2);
      discard.remove(card);
   
      sm.add(xCoord, yCoord, card);
      System.out.println("(" + xCoord + "," + yCoord + ")");
      showToScreen();
   
      return playerNum;
   }

   public static void showStats() {
   
      for (int r = 0; r < sm.numRows(); r++) {
         for (int c = 0; c < sm.numColumns(); c++) {
            Card temp = sm.get(r, c);
            if (temp != null) {
               System.out.println(temp);
               System.out.println("which players card " + temp.getPlayer());
               System.out.println("card's health " + temp.getAtk());
               System.out.println("card's attack " + temp.getHealth());
            }
         }
      }
   }

   public static byte drawCardFromDiscard(byte playerNum, ArrayList<Card> discard) {
      System.out.println("number card in discardPile");
   
      for (int r = 0; r < discard.size(); r++) {
      
         {
            System.out.println(discard.get(r).getName() + " ");
            System.out.print("discard loc " + r);
            
          
            System.out.println(" mc " + discard.get(r).getManacost() + " ");
         }
      
      }
   
      System.out.println();
   
      System.out.println("choose the card you want to play from the discard pile ");
      byte pickingCardFromDiscard = (byte) (input.nextInt());
      Card card = discard.get(pickingCardFromDiscard);
      discard.add(discard.remove(pickingCardFromDiscard));
   
      return playerNum;
   }

   public static byte drawCard(byte pNum) {
   
      if (pNum == 0) {
      
         hand0.add(deck0.remove(0));
      
      }
      
      else {
      
         hand1.add(deck1.remove(0));
      
      }
   
      return 0;
   
   }

   public static byte discard(byte playerNum, ArrayList<Card> hand, ArrayList<Card> discard) {
      System.out.println("cards in your hand");
   
      for (int r = 0; r < hand.size(); r++) {
      
         {
            System.out.println(hand.get(r).getName() + " ");
            System.out.print("hand loc " + r);
            
          
            System.out.println(" mc " + hand.get(r).getManacost() + " ");
         
         }
      
      }
   
      System.out.println();
   
      System.out.println("choose the card you want to discard");
      byte cardToDiscard = (byte) (input.nextInt());
      Card card = hand.get(cardToDiscard);
      discard.add(hand.remove(cardToDiscard));
   
      return playerNum;
   }

   public static void dealBattleDamage(byte xCoord, byte yCoord) {
   
      Card attacker = sm.get(xCoord, yCoord);
      if (attacker == null) {
         System.out.println("no attacker");
         return;
      
      }
      System.out.println("these are all the cards on the field");
      System.out.println("players cards on the field are signified by the number 0 for p1, 1 for p2");
   
      for (int r = 0; r < sm.numRows(); r++) {
         for (int c = 0; c < sm.numColumns(); c++) {
            Card temp = sm.get(r, c);
            if (temp != null) {
            
               System.out.print(temp);
               System.out.print(" " + temp.getPlayer());
            
            }
         }
      
      }
      System.out.println();
   
      sm.add(2, 2, new Commander((byte) 1));
   
      System.out.println("choose the card you want to deal damage to..as an x and y coord ");
      System.out.println("x coord");
      byte xCoord2 = (byte) (input.nextInt());
      System.out.println("y coord");
      byte yCoord2 = (byte) (input.nextInt());
   
      Card defender = sm.get(xCoord2, yCoord2);
      while (defender == null) {
         System.out.println("no defender");
         System.out.println("choose the card you want to deal damage to..as an x and y coord ");
         System.out.println("x coord");
         xCoord2 = (byte) (input.nextInt());
         System.out.println("y coord");
         yCoord2 = (byte) (input.nextInt());
         defender = sm.get(xCoord2, yCoord2);
      
      }
   
      String state = validInputToAttack(xCoord2, yCoord2, xCoord, yCoord);
   
      while (!state.equals("ok")) {
         if (xCoord == xCoord2 && yCoord == yCoord2) {
         
            System.out.println("same position of card");
         
         }
         System.out.println(state);
         showToScreen();
      
         System.out.println("choose the card you want to deal damage to..as an x and y coord ");
         System.out.println("x coord");
         xCoord2 = (byte) (input.nextInt());
         System.out.println("y coord");
         yCoord2 = (byte) (input.nextInt());
         state = validInputToAttack(xCoord2, yCoord2, xCoord, yCoord);
      
      }
   
      for (int r = 0; r < sm.numRows(); r++) {
         for (int c = 0; c < sm.numColumns(); c++) {
            Card temp = sm.get(r, c);
            if (temp != null) {
            
               System.out.print(temp);
               System.out.print(" " + temp.getPlayer());
            
            }
         }
      
         byte atkAtk = attacker.getAtk();
         byte atkHp = attacker.getHealth();
      
         byte defAtk = attacker.getAtk();
         byte defHp = attacker.getHealth();
      
      	// the cards aren't dead
      
         if (atkHp != 0 && defHp != 0) {
         
         	// atker: 2/5 defender: 2/7
         	// takes away the health equal to the atk of each card, then if
         	// it killed the card
         	// print the name of the card and remove it from the board
            if (atkAtk > defHp) {
               defender.setHealth((byte) ((byte) defHp - (byte) atkAtk));
               attacker.setHealth((byte) ((byte) atkHp - (byte) defAtk));
               if (defHp == 0) {
               
                  System.out.println("health of attacker" + atkHp + attacker.getPlayer() + "health of defender"
                     	+ defHp + defender.getPlayer());
               
               }
            
            }
         
         	// atker: 3/2 def: 2/3
         	// if both cards have reverse stats they will both destroy the
         	// opposing cards and remove them from the field
         
            if (atkAtk == defHp)
               attacker.setHealth((byte) 0);
            defender.setHealth((byte) 0);
         
         }
      
      }
      System.out.println("the defending card's attack and health" + defender.getAtk() + " " + defender.getHealth());
   
   }

   public static void showToScreen() {
   
      System.out.println(sm.toString());
   
   }

   public static boolean validInputToPlay(byte r, byte c, byte cardNum, ArrayList<Card> hand, byte playerNum) {
      if (r < 0 || r >= sm.numRows() || c < 0 || c >= sm.numColumns()) {
      
         return false;
      
      }
   
      if (cardNum < 0 || cardNum >= hand.size()) {
         return false;
      }
   
      if (sm.get(r, c) != null) {
      
         return false;
      
      }
      
      if(playerNum == 0)
      {
      
      
      
      //  System.out.println("\t \t" + hand.get(cardNum).getManacost() + "  " + manaCrystal0);
      
         if(hand.get(cardNum).getManacost() > manaCrystal0)
         {
         
            return false;
         
         }
         
      }
         
      else
      { 
         if(hand.get(cardNum).getManacost() > manaCrystal1)
         {
            
            return false;
            
            
         }
      }
      
         
      for (int row = r - 1; row <= r + 1; row++)
         for (int col = c - 1; col <= c + 1; col++) {
            if (row == r && col == c)
               continue;
            Card temp = sm.get(row, col);
            if (temp != null && temp.getPlayer() == playerNum)
               return true;
         
         }
      return false;
   
   }

   public static String validInputToAttack(byte vr, byte vc, byte ar, byte ac) {
      if (vr < 0 || vr >= sm.numRows() || vc < 0 || vc >= sm.numColumns()) {
      
         return "victim bad coordinates";
      
      }
      if (ar < 0 || ar >= sm.numRows() || ac < 0 || ac >= sm.numColumns()) {
      
         return "attacker bad coordinates";
      
      }
      if (vr == ar && vc == ac) {
      
         return "cannot attack each other ";
      
      }
   
      Card attacker = sm.get(ar, ac);
      Card victim = sm.get(vr, vc);
      if (attacker == null || victim == null) {
      
         return "no one to attack";
      
      }
   
      if (attacker.getPlayer() == victim.getPlayer()) {
      
         return "cannot attack own cards ";
      
      }
      byte dr = (byte) Math.abs(vr - ar);
      byte dc = (byte) Math.abs(vc - ac);
   
      if (dr <= 1 && dc <= 1)
         return "ok";
      return "not adjacent";
   
   }

}

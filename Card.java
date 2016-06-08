

//package sparseMatrix;

import java.util.*;

public class Card {
   private byte[] Stats = new byte[12];//0=manacost
 
 
 //battlecrys 1 - 10
 
 //1: deal damage
 //2: heal 
 //3: draw a card
 //4: exile a target card
 //5: destroy a target card
 //6: charge
 //7: gain 1+/1+

   private final int MANACOST = 0, ATK =1, HEALTH = 2, BATTLECRY = 3, DEATHRATTLE = 4, STARTOFTURN = 5, ENDOFTURN = 6,
   	TAUNT = 7, PLAYER = 8, BATTLECRYDAMAGE = 9, HEALING = 10, TURNPLAYED = 11;
   private String NAME;
 //Scanner input = new Scanner(System.in);

   public Card(String N,byte M, byte A, byte H, byte B, byte D, byte S, byte E, byte T, byte P,byte BD, byte HE, byte TP)
   
   //The card and things that are required, in this case all of the values of the card if it has...
   
   {
   
     
      NAME = N;
    
      Stats[MANACOST] = M;
      Stats[ATK] = A;
      Stats[HEALTH] = H;
      Stats[BATTLECRY] = B; //enters the field
      Stats[DEATHRATTLE] = D; //leaves the field
      Stats[STARTOFTURN] = S; // effects at the start of turn
      Stats[ENDOFTURN] = S; //effects at the end of turn
      Stats[TAUNT] = T; // can only be attacked in the radius
      Stats[PLAYER] = P; // playerNum
      Stats[BATTLECRYDAMAGE] = BD; //damage done by the battlecry, i.e. deal 3 damage
      Stats[HEALING] = HE; //healing done by the battlecry, i.e. heal 3 damage
      Stats[TURNPLAYED] = TP; //summoning sickness; all cards cant attack the turn they are played
   
   }
 

 
 
 
   public Card(String x) 
   
   {
   
   //finding indicies of all commas
   
      int[] CommaLoc = new int[12];
    
      for(int i =0; i < CommaLoc.length; i++) 
      {
      
         if(i == 0)
            CommaLoc[i] = x.indexOf(",");
         else
            CommaLoc[i] = x.indexOf(",", CommaLoc[i -1]+1);    
      
      
      
      
      }   
      NAME = x.substring(0,x.indexOf(","));
      x = x.substring(x.indexOf(",") +1);
      String[] parts = x.split(",");
   
    //NAME = parts[0];//x.substring(0,CommaLoc[0]);
      Stats[MANACOST] =  Byte.parseByte(parts[MANACOST]);      //x.substring(CommaLoc[0]+1,CommaLoc[1]));
      Stats[ATK] = Byte.parseByte(parts[ATK]);     //CommaLoc[1]+1,CommaLoc[2]));
      Stats[HEALTH] = Byte.parseByte(parts[HEALTH]);     //CommaLoc[2]+1,CommaLoc[3]));
      Stats[BATTLECRY] = Byte.parseByte(parts[BATTLECRY]);     // x.substring(CommaLoc[4]+1,CommaLoc[5]));
      Stats[STARTOFTURN] = Byte.parseByte(parts[STARTOFTURN]);// x.substring(CommaLoc[5]+1,CommaLoc[6]));
      Stats[ENDOFTURN] = Byte.parseByte(parts[ENDOFTURN]); //x.substring(CommaLoc[6]+1,CommaLoc[7]));
      Stats[TAUNT] = Byte.parseByte(parts[TAUNT]);// x.substring(CommaLoc[7]+1));
      Stats[BATTLECRYDAMAGE] = Byte.parseByte(parts[BATTLECRYDAMAGE]);
      Stats[HEALING] = Byte.parseByte(parts[HEALING]);
      Stats[TURNPLAYED] = Byte.parseByte(parts[TURNPLAYED]);
   
   }
 
 
 
 
 
 //change mana cost
 // changing attack + and -
 // changing health + and -
 // battlecry, damaging and other effects from cards
 //start of turn effects will trigger battlecry effects not the actual effect but calling the method to increase attack
 //give taunt / remove taunt 
 //program taunt
 
 /*
 
 public void move(byte d)
 {
 
    switch(d)
    {
    
       case 0: //if case = 0
       
          if(r > 0)
          {
          
             r++;
          
          }
       
       
       //code to go up
          break;
       case 1:
       
       if()
       
       
       //code to go right
       
          break;
    
       case 2:
       
       //code to go down
       
          break;
    
    
       case 3:
       
       
       //code to go left
       
          break;
    
    
    
       default: 
          break;
    
    }
 
 
 }
*/

   public String getName() {
   
      return NAME;
   
   }

   public byte getManacost() {
      return Stats[MANACOST];
   }

   public void setManacost(byte nManacost) {
      Stats[MANACOST] = nManacost;
   
   }

   public byte getAtk() {
   
      return Stats[ATK];
   
   }

   public void setAtk(byte nAtk) {
      Stats[ATK] = nAtk;
   
   }

   public byte getHealth() {
      return Stats[HEALTH];
   
   }

   public void setHealth(byte nHealth) {
   
      Stats[HEALTH] = nHealth;
   
   }

   public byte getBattlecry() {
      return Stats[BATTLECRY];
   }

   public void setBattlecry(byte nBattlecry) {
      Stats[BATTLECRY] = nBattlecry;
   }

   public byte getDeathrattle() {
   
      return Stats[DEATHRATTLE];
   
   }

   public void setDeathrattle(byte nDeathrattle) {
   
      Stats[DEATHRATTLE] = nDeathrattle;
   
   }

   public byte getStartOfTurn() {
      return Stats[STARTOFTURN];
   }

   public void setStartOfTurn(byte nStartOfTurn) {
   
      Stats[STARTOFTURN] = nStartOfTurn;
   
   }

   public byte getEndOfTurn() {
      return Stats[ENDOFTURN];
   }

   public void setEndOfTurn(byte nEndOfTurn) {
   
      Stats[ENDOFTURN] = nEndOfTurn;
   
   }

   public byte getTaunt() {
      return Stats[TAUNT];
   }

   public void setTaunt(byte tAUNT) {
      Stats[TAUNT] = tAUNT;
   }

   public byte getPlayer() {
   
      return Stats[PLAYER];
   
   }

   public void setPlayer(byte nPlayer) {
   
      Stats[PLAYER] = nPlayer;
   
   }
 
 
 //Stats[HEALING] = Byte.parseByte(parts[HEALING]);

 
   public byte getBattlecryDamage() {
    
      return Stats[BATTLECRYDAMAGE];
   
   }

   public void setBattlecryDamage(byte nBattlecryDamage) {
    
      Stats[BATTLECRYDAMAGE] = nBattlecryDamage;
    
   }
 
   public byte getHEALING() {
    
      return Stats[BATTLECRYDAMAGE];
    
   }

   public void setHealing(byte nHealing) {
   	 
      Stats[HEALING] = nHealing;
   	 
   }
	 
    
   public void setTurnPlayed(byte nTURNPLAYED)
   {
   
      Stats[TURNPLAYED] = nTURNPLAYED;
   
   }
  
   public byte getTurnPlayed()
   {
   
      return Stats[TURNPLAYED];
   
   }



   public String toString() {
   
      return NAME.substring(0, 1); //+ " mc " + Stats[0];
   // return " Name of card " + NAME + " Attack value " + ATK + " Health
   // value" + HEALTH + "If it has deathrattle"
   // + DEATHRATTLE + "If it has a start of turn ability" + STARTOFTURN +
   // "if it has end of turn abilities"
   // + ENDOFTURN;
   
   }

}

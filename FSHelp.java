import java.util.*;

public class FSHelp {
   
   char[] r1 = new char[7];
   char[] r2 = new char[7];
   
   public FSHelp(char[] s1, char[] s2) {
      r1=s1;
      r2=s2;
      display();
   }
   
   public String compact(char a) {
      if (a=='0') {
         return("fff");
      } else if (a=='1') {
         return("101fff");
      } else if (a=='2') {
         return("102fff");
      } else if (a=='3') {
         return("201fff");
      } else if (a=='4') {
         return("202fff");
      } else if (a=='5') {
         return("101201fff");
      } else if (a=='6') {
         return("101202fff");
      } else if (a=='7') {
         return("102201fff");
      } else if (a=='8') {
         return("102202fff");
      } else {
         return("100");
      }
   }
   
   public String triangle(char a) {
      if (a=='A') {
         return("5756");
      } else if (a=='B') {
         return("1215");
      } else if (a=='C') {
         return("5657");
      } else if (a=='D') {
         return("3534");
      } else if (a=='E') {
         return("0103");
      } else if (a=='F') {
         return("3435");
      } else if (a=='G') {
         return("5646");
      } else if (a=='H') {
         return("1535");
      } else if (a=='I') {
         return("3515");
      } else if (a=='J') {
         return("7868");
      } else if (a=='K') {
         return("2757");
      } else if (a=='L') {
         return("5727");
      } else if (a=='M') {
         return("1512");
      } else if (a=='N') {
         return("0301");
      } else if (a=='O') {
         return("6878");
      } else if (a=='P') {
         return("4656");
      } else {
         return("");
      }
   }
   
   public void parseFaster(String input) {
      for (int i = 0; i < input.length(); i++) {
         parseFast(triangle(input.charAt(i)));
         align();
         display();
      }
   }
   
   public void parseFast(String input) {
      for (int i = 0; i < input.length(); i++) {
         parseSlow(compact(input.charAt(i)));
         align();
         //display();
      }
   }
   
   public void parseSlow(String input) {
      if (input.length()%3!=0) {
         System.out.println("Invalid input!");
         display();
      } else {
         int i = 0;
         while (3*i!=input.length()) {
            parseArb(input.substring(3*i,3*i+3),0);
            i++;
         }
      }
   }
   
   public void parseArb(String input, int disp) {
      if (input.equals("fff")) {
         flip();
      } else if (input.matches(".*[a-z].*")||input.matches(".*[A-Z].*")) {
         System.out.println("Invalid input>");
      } else {
         int a = Character.getNumericValue(input.charAt(0));
         int b = Integer.valueOf(input.substring(1,3));
         if (a != 1 && a != 2) {
            System.out.println("Invalid row.");
         } else if (b<-2 || b>2) {
            System.out.println("Invalid move.");   
         } else {   
            shift(a,b);
         }
      }
      if (disp==1&&input.equals("fff")) {
         display();
      } else if (disp==2&&input.equals("fff")) {
         System.out.println(state());
      }
   }   
   
   public void align() {
      while(r1[0]=='X') {
         parseArb("1-1",0);
      }
      while(r2[0]=='X') {
         parseArb("2-1",0);      
      }   
   }
   
   public void flip() {
      char a = r1[2];
      char b = r1[3];
      char c = r1[4];
      r1[2] = r2[2];
      r1[3] = r2[3];
      r1[4] = r2[4];
      r2[2] = a;
      r2[3] = b;
      r2[4] = c;
   }
   
   public void shift(int row, int move) {
      if (row == 1) {
         r1 = shiftH(r1, move);
      } else if (row == 2) {
         r2 = shiftH(r2, move);
      } else {
         System.out.println("Invalid row.");
      }
   }
   
   public char[] shiftH(char[] row, int move) {
      int x = 0;
      while (row[x]=='X') {
         x++;
      }
      if (-1*x>move || move>2-x) {
         //System.out.println("Invalid move.");
      } else {
         if (move>0) {
            for (int i = 7; i>move; i--) {
               row[i-1] = row[i-1-move];
            }
            for (int i = 0; i<move; i++) {
               row[i] = 'X';
            }         
         } else if (move<0) {
            for (int i = 0; i<7+move; i++) {
               row[i] = row[i-move];
            }
            for (int i = 7; i>7+move; i--) {
               row[i-1] = 'X';
            }
         }
      }
      return row;
   }
   
   public String state() {
      String temp = ""+Arrays.toString(r1)+Arrays.toString(r2);
      temp = temp.replaceAll("\\D+","");
      return temp;
   }
   
   public boolean isSolved() {
      return state().equals("0123456789");
   }
   
   public void reset() {
      char[] s1 = {'0','1','2','3','4','X','X'};
      char[] s2 = {'5','6','7','8','9','X','X'};
      r1 = s1;
      r2 = s2;
   }
   
   public void display() {
      for (int i = 0; i < 7; i++) {
         System.out.print(r1[i]);
      }
      System.out.println();
      for (int i = 0; i < 7; i++) {
         System.out.print(r2[i]);
      }
      System.out.println();
      System.out.println();
   }
}
import java.util.*;

public class FlipSide {
   public static void main(String[] args) {
      char[] s1 = {'3','0','1','7','4','X','X'};
      char[] s2 = {'5','6','8','9','2','X','X'};
      game(s1, s2);   
      /*for (char i = 'A'; i < 'Q'; i++) {
         for (char j = 'A'; j < 'Q'; j++) {
            for (char k = 'A'; k < 'Q'; k++) {
               for (char l = 'A'; l < 'Q'; l++) {
                  for (char m = 'A'; m < 'Q'; m++) {
                     String s = ""+i+j+k+l+m;
                     int a = eqInput(s);
                     if (a<=2&&a!=0) {
                        System.out.println(""+a+" "+s);
                     }
                  }     
               }
            }
         }      
      }*/
   }
   
   public static int eqInput(String a) {
      char[] s1 = {'0','1','2','3','4','X','X'};
      char[] s2 = {'5','6','7','8','9','X','X'};
      FSHelp g = new FSHelp(s1,s2);
      g.parseFaster(a);
      String t1 = g.state();
      return (dist(t1,"0123456789"));
   }
   
   public static int dist(String t1,String t2) {
      if (t1.length()!=t2.length()) {
         System.out.println("Mismatched strings.");
         return 0;
      }
      int j = 0;
      for (int i = 0; i < t1.length(); i++) {
         if (t1.charAt(i)!=t2.charAt(i)) {
            j++;
         }
      }
      return j;
   }
   
   public static void game(char[] s1, char[] s2) {
      FSHelp g = new FSHelp(s1,s2);
      Scanner s = new Scanner(System.in);
      while (true) {
         g.parseFaster(s.next());
      }
      //g.parseFast("0301");
   }  
}
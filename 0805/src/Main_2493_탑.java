import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      Stack<Integer> s = new Stack<Integer>();

      int n = Integer.parseInt(bf.readLine());
      ArrayList<Integer> arr = new ArrayList<Integer>();

      st = new StringTokenizer(bf.readLine(), " ");

      arr.add(Integer.parseInt(st.nextToken()));
      s.push(arr.get(0));
      System.out.print(0+" ");
 
      for (int i = 1; i < n; i++) {
         arr.add(Integer.parseInt(st.nextToken()));
         
         while (s.peek() < arr.get(i)) {
            s.pop();
            if(s.empty()) {System.out.print(0+" ");s.push(arr.get(i));continue;}
         } 
         
         if(s.peek() > arr.get(i)) {System.out.print(arr.indexOf(s.peek())+1+" ");}
         s.push(arr.get(i));
         
      }

   }

}
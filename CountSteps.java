import java.util.Scanner;

/** Ladder*/
public class CountSteps {
	public static void main(String args[] ){
       
      Scanner in = new Scanner(System.in);
      int MOD = 1000000007;
      int t = in.nextInt();
      int n = in.nextInt();
      in.nextLine();
      while(t>0){
      	t--;
      	int curr = in.nextInt();
      	int k = in.nextInt();
      	
      	int[] count = new int[curr+1];
      	count[0] = 1;
      	int[] steps = { 2,5,k};
      	
      	for(int i=1; i <= curr; i++){
      		for(int j=0; j < 3; j++){
      			if(i >= steps[j]) count[i] += count[i-steps[j]];
      		}     		
      	}
      	
      	System.out.println(count[curr]);
      }
      
    }
}

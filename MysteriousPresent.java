import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;

/** Read only the envelopes whose dimension is strictly greater than the card, i.e. make an object with index, width, height *
 *  Sort the envelopes 
 *  Longest Increasing Subsequence - comes in because of the strictly greater than condition, otherwise it would have been just the sorted array
 *  Print maxLength, and store index at which it becomes
 *  To get the path, use  a stack, push in the maxIndex, and recursively push the parent from path array, until -1
 *  Finally pop out the index number, and get the actual position from the corresponding
 */

public class MysteriousPresent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int w = in.nextInt();
		int h = in.nextInt();
		
		Dimensions[] input = new Dimensions[n];
		int index =0;
		
		for(int i=0; i < n; i++){
			int width = in.nextInt();
			int height = in.nextInt();
			if(w < width && h < height)
			input[index++] = new Dimensions(i,width,height);
		}
		
		Arrays.sort(input,0,index);
		
		int[] path = new int[index];
		int[] lis = new int[index];
		int maxLength=1;
		int maxIndex = 0;
		
		for(int i=0; i < index;i++){
			lis[i] = 1;
			path[i] = -1;
		}
		
		for(int i=1; i < index;i++){
			for(int j=0; j <i; j++){
				if((input[i].compareTo(input[j])== 1 ) && (lis[i]  < lis[j] + 1) ){
					lis[i] = lis[j] + 1;
					path[i] = j;
					if(maxLength < lis[i]) {
						maxLength = lis[i];
						maxIndex =i;
					}
				}
			}
		}
		
		System.out.println(maxLength);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(maxIndex);
		while(path[maxIndex] >=0){
			stack.push(path[maxIndex]);
			maxIndex = path[maxIndex];
		}
		
		
		while(!stack.isEmpty()){
			System.out.print(input[stack.pop()].index + 1 + " ");
		}
		System.out.println();
	}

}
class Dimensions implements Comparable<Dimensions>{
	
	int index;
	int width;
	int height;
	
	Dimensions(int index,int width, int height){
		this.index = index;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int compareTo(Dimensions o) {
		// TODO Auto-generated method stub
		if(this.width < o.width) return -1;
		else if (this.width == o.width && this.height < o.height) return -1;
		else return 1;
	}
	
}

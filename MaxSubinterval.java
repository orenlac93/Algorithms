
public class MaxSubinterval {
	
	/**
	 * patient greedy algorithm      O(n)
	 * @param a array of numbers
	 * @return maximum sum sub array of a
	 * prints the indexes of the sub interval [a , b]
	 */
	public static int MaxSI(int a[]) {
		int max = 0 , sum = 0;
		int start = 0 , finish = 0;
		
		for(int i = 0 ; i < a.length ; i++) {
			sum = sum + a[i];
			finish = i;
			if(sum < 0) {
				sum  = 0;
				start = i + 1;
				finish = i + 1;
			}	
			else {
				if(sum > max) {
					max = sum;
				}	
			}
		}
		System.out.println("[" + start + " , " + finish + "]");
		return max;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,2,-10,3,4,-5,6,7,-1,2}; // max = 16 , [3 , 9]
		int[] arr2 = {3,-2,5,1}; // max = 7 , [0 , 3]
		
		System.out.println(MaxSI(arr1));
		//System.out.println(MaxSI(arr2));

	}

}

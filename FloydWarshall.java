
public class FloydWarshall {
	
	static final int inf = 999999999;
	
	
	/**
	 * boolean Floyd-Warshall Algorithm		   O(n^3)
	 * @param mat				             
	 * @return
	 */
	public static Boolean[][] floydWarshall(Boolean[][] G){
		
		Boolean[][] T = new Boolean[G.length][G[0].length];
		T = G;
		
		for(int k = 0 ; k < T.length ; k++) {
			for(int i = 0 ; i < T.length ; i++) {
				for(int j = 0 ; j < T.length ; j++) {
					T[i][j] = (T[i][k] && T[k][j]) || T[i][j];
				}
			}
		}
		return T;
	}
	
	
	/**
	 * distance Floyd-Warshall Algorithm		O(n^3)
	 * @param mat
	 * @return
	 */
	public static Integer[][] floydWarshall(Integer[][] G){
		
		Integer[][] D = new Integer[G.length][G[0].length];
		D = G;
		
		for(int k = 0 ; k < D.length ; k++) {
			for(int i = 0 ; i < D.length ; i++) {
				for(int j = 0 ; j < D.length ; j++) {
					D[i][j] = Math.min(D[i][j] , (D[i][k]) + D[k][j]);
				}
			}
		}
		return D;
	}
	
	/**
	 * print a generic array
	 * @param arr
	 */
	public static <T> void printArr(T[][] arr) {
		
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[0].length ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 *   (v1)__(v2)
		 *         /   
		 *      (v3)
		 */
		boolean[][] mat1 = {
				{true , true , false},
				{true , true , true},
				{false ,true , true}
		};
		
		
		/* 
		 *   (v1)     (v3)  (v5)
		 *     \         \  /   
		 *     (v2)      (v4)
		 */
		Boolean[][] mat2 = {
				{true , true , false , false , false},
				{true , true , false , false , false},
				{false , false , true , true , false},
				{false , false , true , true , true},
				{false , false , false , true , true}
		};
		
		Boolean[][] solve = floydWarshall(mat2);
		printArr(solve);
		

		
		
		
		Integer[][] G1 = {
				{0,1,inf,3},
				{1,0,11,inf},
				{inf,11,0,5},
				{3,inf,5,0}
		};
		
		Integer[][] dist = floydWarshall(G1);
		printArr(dist);
		


	}
	


}

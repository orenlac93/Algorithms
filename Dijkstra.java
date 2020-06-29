import java.util.*;
public class Dijkstra {

	static final int inf = 999999999;


	/**
	 * Dijkstra shortest path algorithm		   O(E + V*log(V))
	 * @param G weights matrix
	 * @param n adjacency list 
	 * @param src source vertex
	 * @param dst destination vertex
	 * @return shortest path (src --> dst) weight
	 */
	public static int dijkstra(Integer[][] G , ArrayList<ArrayList<Integer>> n , int src , int dst){

		int[] dist = new int[G.length]; // array of each vertex distance from src
		boolean[] visited = new boolean[G.length]; // array of visited vertexes
		PriorityQueue<Integer> Q = new PriorityQueue<Integer>(); // priority queue of distances
		int ans = inf; // answer variable

		/* initializing the distances to infinity */
		for(int i = 0 ; i < dist.length ; i++) {
			dist[i] = inf;
		}
		
		/* initializing source to 0 */
		dist[src] = 0; 
		
		/* initializing the queue */
		for(int i = 0 ; i < dist.length ; i++) {
			Q.add(dist[i]);
		}
		
		int current_indx = -1; // use to save the index of the vertex returned from the queue

		while(!Q.isEmpty()) {
			int u = Q.poll();	

			for(int i = 0 ; i < dist.length ; i++) {
				if(u == dist[i]) {
					visited[i] = true;
					current_indx = i;
				}

			}

			for(int v : n.get(current_indx)) {
				if(!visited[v]){
					if(dist[v] > u + G[current_indx][v]) {
						int weight_before = dist[v];
						dist[v] = u + G[current_indx][v];
						Q.remove(weight_before);
						Q.add(dist[v]);
					}
				}
			}

		}
		
		ans = dist[dst]; 

		return ans;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 *       (v1)      (v4)
		 *      /   \      /
		 *     2     6    3
		 *    /       \  /
		 * (v0)       (v3)
		 *    \       /
		 *     4     1
		 *      \   /       
		 *       (v2)      
		 */

		Integer[][] G1 = {
				{0,2,4,inf,inf},
				{2,0,inf,6,inf},
				{4,inf,0,1,inf},
				{inf,6,1,0,3},
				{inf,inf,inf,3,0}
		};

		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>(5);

		ArrayList<Integer> v0 = new ArrayList<Integer>();
		v0.add(1);
		v0.add(2);
		ArrayList<Integer> v1 = new ArrayList<Integer>();
		v1.add(0);
		v1.add(3);
		ArrayList<Integer> v2 = new ArrayList<Integer>();
		v2.add(0);
		v2.add(3);
		ArrayList<Integer> v3 = new ArrayList<Integer>();
		v3.add(1);
		v3.add(2);
		v3.add(4);
		ArrayList<Integer> v4 = new ArrayList<Integer>();
		v4.add(3);
		
		neighbors.add(v0);
		neighbors.add(v1);
		neighbors.add(v2);
		neighbors.add(v3);
		neighbors.add(v4);
		
		int d = dijkstra(G1,neighbors,0,4);
		System.out.println("shortest path form v0 to v4 cost : " + d);


	}

}

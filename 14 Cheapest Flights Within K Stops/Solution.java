/*
Problem : 
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200

Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500

*/

/*
Analysis ::
Time Complexity :: O(nlogn)
Space Complexity :: O(n)
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] f: flights){
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[] { f[1], f[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        heap.add(new int[]{src, 0, K+1});
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int node = curr[0];
            int price = curr[1];
            int stops = curr[2];
            if(node == dst)
                return price;
            if(!graph.containsKey(node))
                continue;
            if(stops > 0){
                for(int[] adj: graph.get(node)){
                    heap.offer(new int[] { adj[0], price+adj[1], stops-1});
                }
            }
        }
        return -1;
    }
}
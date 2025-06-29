class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        for(int i=0;i<V;i++){//traverse component wise
            if(vis[i]==0){
                dfsCheck(i,graph,vis,pathVis,check);
            }
        }
        List<Integer> safenodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                safenodes.add(i);
            }
        }
        return safenodes;
    }

    boolean dfsCheck(int node, int[][] graph, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        //traverse neighbors
        for(int it : graph[node]){
            if(vis[it]==0){
                if(dfsCheck(it, graph, vis, pathVis, check)==true){
                    return true;//cycle detected
                }
            }
            else if(pathVis[it]==1){
                return true;
            }
        }
        check[node] = 1;//safe node - during backtrack
        pathVis[node] = 0;
        return false;
    }
}
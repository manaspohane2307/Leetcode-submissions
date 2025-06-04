class Solution {
    void dfs(ArrayList<ArrayList<Integer>> adjlist, int[] vis, int node){
        vis[node] = 1;
        //get neighbors
        for(int it : adjlist.get(node)){
            if(vis[it]==0){
                dfs(adjlist,vis,it);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        int v = isConnected.length;//no of nodes
        for(int i=0;i<v;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        //change adjmatrix to list
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }
        int[] vis = new int[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                count++;
                dfs(adjlist,vis,i);
            }
        }
        return count;
    }
}
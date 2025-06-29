class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);  // edge from v → u
        }
        
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        //ArrayList<Integer> ans = new ArrayList<>();
        int ans_size=0;
        Queue<Integer> q = new LinkedList<>();
        //put elements into queue with indegree 0
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //start bfs
        while(!q.isEmpty()){
            int val = q.poll();
            //ans.add(val);
            ans_size++;
            //reduce indegree of neighbors
            for(int it : adj.get(val)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return (ans_size == numCourses);
    }
}
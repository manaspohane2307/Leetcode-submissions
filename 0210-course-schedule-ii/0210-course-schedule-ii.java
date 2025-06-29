class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int count=0;
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
            ans.add(val);
            //reduce indegree of neighbors
            for(int it : adj.get(val)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(ans.size() != numCourses){
            return new int[0];
        }
        int[] order = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            order[i] = ans.get(i);
        }
        
        return order;
    }
}
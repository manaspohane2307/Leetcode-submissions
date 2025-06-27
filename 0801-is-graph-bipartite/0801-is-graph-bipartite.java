class Solution {
    public boolean isBipartite(int[][] graph) {
        //adjlist
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int n : graph[i]) {
                adjlist.get(i).add(n);
            }
        }
        int n = graph.length;
        //mark all colors -1 initially
        int[] colors = new int[n];//each node is numbered between 0 and 1
        for (int i = 0; i < n; i++) {
            colors[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (check(i, adjlist, colors) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int start, ArrayList<ArrayList<Integer>> adjlist, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        //we use 2 colors - 0 and 1
        q.add(start);//source node
        colors[start] = 0;

        //bfs
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            //find neighbors
            for (int it : adjlist.get(node)) {
                if (colors[it] == -1) {
                    colors[it] = 1 - colors[node];//opp color
                    q.add(it);
                } else if (colors[it] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
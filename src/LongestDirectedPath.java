
class LongestDirectedPath {

    // Function to perform topological sort
    static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        //Array to store innerDegree of a Node
        int[] indegree = new int[V];
        //Calculating the innerDegrees of all Nodes
        for (int i = 0; i < V; i++) {
            for (int item : adj.get(i)) {
                indegree[item]++;
            }
        }

        //Storing the Nodes with inDegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        //Array to store the topological order
        int[] topo = new int[V];
        int i = 0;

        //Process all the nodes that are in queue
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;
            //Decreasing the inDegree of all adjacent Nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }


    // Function to find the longest path from a given
    static int[] longestPath(int V, ArrayList<ArrayList<Integer>> adj, int start) {
        int[] topo = topologicalSort(V, adj);
        //Array to store the longest path distances
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[start] = 0;

        //Performing operations on each vertex in topological order
        for (int i = 0; i < V; i++) {
            int node = topo[i];
            if (distance[node] != Integer.MIN_VALUE) {
                for (int it : adj.get(node)) {
                    if (distance[node] + 1 > distance[it]) {
                        distance[it] = distance[node] + 1;
                    }
                }
            }
        }
        return distance;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        //Initializing the Adjacency list to store the dependencies of a Node
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (from to):");
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            adj.get(from).add(to);
        }

        System.out.println("Enter the starting vertex:");
        int start = scanner.nextInt();

        int[] longestPaths = longestPath(V, adj, start);

        System.out.println("Longest path distances from vertex " + start + ": "+longestPaths[V-1]);
        for (int i = 0; i < V; i++) {
            if (longestPaths[i] == Integer.MIN_VALUE) {
                System.out.println("Vertex " + i + ": No path");
            } else {
                System.out.println("Vertex " + i + ": " + longestPaths[i]);
            }
        }
    }
}

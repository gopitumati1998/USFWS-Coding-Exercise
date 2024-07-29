Q) Does the solution work for larger graphs? 

Ans) the solution works for larger graphs as long as they are directed acyclic graphs (DAGs). The algorithm will handle graphs with a number of vertices and edges efficiently. Because it has linear time complexity with respect to the number of vertices and edges.




Q) Can you think of any optimizations? 

Ans) The solution is more optimal with linear time and space complexity. We can optimize a littile bit by using Arrays.asList() can simplify the initialization, Instead of manually adding empty lists.


Q) What’s the computational complexity of your solution? 

Ans) Time Complexity: O(V+E)  Space Complexity(V+E)  Here, V is no.of Vertices  and E is the no of Edges. These complexities are efficient.
	

Q) Are there any unusual cases that aren't handled? 
Ans) This solution is only works for Directed Acyclic Graphs only and This solution is not suitable for the graph, which is disconnected, some vertices may not be reachable from the starting vertex.

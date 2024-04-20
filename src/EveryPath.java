import java.util.*;

class EveryPath{

    static int V = 6;
    static int INF = Integer.MAX_VALUE;

    static void allSimplePaths(int u, int destination, int length, ArrayList<Integer> path, boolean visited[], int graph[][]) {
        if (length == 5) {
            if (u == destination) {
                System.out.print("Path: ");
                for (int node : path) {
                    System.out.print(node + " ");
                }
                System.out.println(destination);
            }
            return;
        }

        visited[u] = true;
        path.add(u);

        for (int i = 0; i < V; i++) {
            if (graph[u][i] != INF && !visited[i]) {
                allSimplePaths(i, destination, length + 1, path, visited, graph);
            }
        }

        visited[u] = false;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int graph[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = INF;
            }
        }

        boolean visited[] = new boolean[V];

        graph[0][1] = 1;
        graph[1][2] = 1;
        graph[2][3] = 1;
        graph[3][4] = 1;
        graph[4][5] = 1;

        int s = 0, t = 5;

        visited[s] = true;

        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);

        System.out.println("Simple paths of length 5 from " + s + " to " + t + ":");
        allSimplePaths(s, t, 0, path, visited, graph);
    }
}

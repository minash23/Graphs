public class DirectedOrUndirected {
    public static boolean isDirectedGraph(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // non-zero at matrix[i][j] and matrix[j][i] is zero
                if ((matrix[i][j] != 0 && matrix[j][i] == 0) || (matrix[i][j] == 0 && matrix[j][i] != 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        if (isDirectedGraph(adjacencyMatrix)) {
            System.out.println("The graph is directed.");
        } else {
            System.out.println("The graph is undirected.");
        }
    }
}

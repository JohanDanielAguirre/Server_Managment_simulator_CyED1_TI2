<<<<<<< HEAD
package model;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyMatrix<V> {
    private int numVertices;
    private int[][] adjacencyMatrix;
    private List<V> vertices;

    public GraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    public void addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            numVertices++;

            int[][] newMatrix = new int[numVertices][numVertices];
            for (int i = 0; i < numVertices - 1; i++) {
                System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, numVertices - 1);
            }
            adjacencyMatrix = newMatrix;
        }
    }


    public void removeVertex(V vertex) {
        int vertexIndex = vertices.indexOf(vertex);
        vertices.remove(vertexIndex);
        numVertices--;

        int[][] newMatrix = new int[numVertices][numVertices];
        int rowIndex = 0;
        int colIndex;
        for (int i = 0; i < numVertices + 1; i++) {
            if (i != vertexIndex) {
                colIndex = 0;
                for (int j = 0; j < numVertices + 1; j++) {
                    if (j != vertexIndex) {
                        newMatrix[rowIndex][colIndex] = adjacencyMatrix[i][j];
                        colIndex++;
                    }
                }
                rowIndex++;
            }
        }
        adjacencyMatrix = newMatrix;
    }

    public void addEdge(V source, V destination, int weight) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);

        if (sourceIndex != -1 && destinationIndex != -1) {
            adjacencyMatrix[sourceIndex][destinationIndex] = weight;
            adjacencyMatrix[destinationIndex][sourceIndex] = weight;
        }
    }

    public void removeEdge(V source, V destination) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);

        if (sourceIndex != -1 && destinationIndex != -1) {
            adjacencyMatrix[sourceIndex][destinationIndex] = 0;
            adjacencyMatrix[destinationIndex][sourceIndex] = 0;
        }
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
=======
package model;public class GraphAdjacencyMatrix {


>>>>>>> 637720a109df45a6217e11a870583138861498de
}

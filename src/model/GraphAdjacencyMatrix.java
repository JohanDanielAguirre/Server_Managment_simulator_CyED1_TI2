package model;

import java.util.*;

public class GraphAdjacencyMatrix<V extends Vertex<V>> implements Graph<V>{
    private int numVertices;
    private int[][] adjacencyMatrix;
    private List<V> vertices;

    public GraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    public void agregarVertice(Vertex vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add((V) vertice);
            numVertices++;

            int[][] newMatrix = new int[numVertices][numVertices];
            for (int i = 0; i < numVertices - 1; i++) {
                System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, numVertices - 1);
            }
            adjacencyMatrix = newMatrix;
        }
    }

    @Override
    public boolean deleteVertex(Vertex<V> vertex) {
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

        return true; //Hay que cambiar esto
    }

    @Override
    public int[] Dijsktra(Vertex<V> start) {
        return new int[0];
    }

    public void agregarArista(Vertex origen, Vertex destino, int peso) {
        int sourceIndex = vertices.indexOf(origen);
        int destinationIndex = vertices.indexOf(destino);

        if (sourceIndex != -1 && destinationIndex != -1) {
            adjacencyMatrix[sourceIndex][destinationIndex] = peso;
            adjacencyMatrix[destinationIndex][sourceIndex] = peso;
        }
    }
    @Override
    public void deleteEdge(Vertex<V> source, Vertex<V> destination) {
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

    private Vertex<V> findVertex(Vertex<V> value) {
        for (Vertex<V> vertex : vertices) {
            if (vertex.getDato().equals(value)) {
                return vertex;
            }
        }
        return null; // Vertex not found
    }

    @Override
    public void bfs(Vertex v) {
        if (vertices.size() > 0) {
            Vertex<V> startVertex = findVertex(v);
            if (startVertex != null) {
                for (V vertex : vertices) {
                    vertex.setC(Colors.WHITE);
                    vertex.setDistance(0);
                    vertex.setParent(null);
                }
                bfsInner(startVertex);
            }
        }
    }

    private void bfsInner(Vertex<V> v) {
        v.setC(Colors.GREY);
        v.setDistance(0);
        v.setParent(null);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex<V> u = queue.poll();

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertices.indexOf(u)][i] != 0) {
                    Vertex<V> adj = (Vertex<V>) vertices.get(i);

                    if (adj.getC() == Colors.WHITE) {
                        adj.setC(Colors.GREY);
                        adj.setDistance(u.getDistance() + 1);
                        adj.setParent(u);
                        queue.add(adj);
                    }
                }
            }

            u.setC(Colors.BLACK);
        }
    }


    @Override
    public void dfs() {
        if (vertices.size() > 0) {
            for (Vertex<V> v : vertices) {
                v.setC(Colors.WHITE);
                v.setParent(null);
            }
            int time = 0;
            for (Vertex<V> v : vertices) {
                if (v.getC() == Colors.WHITE) {
                    time = dfsInner(v, time);
                }
            }
        }
    }

    private int dfsInner(Vertex<V> v, int time) {
        time += 1;
        v.setDistance(time);
        v.setC(Colors.GREY);

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertices.indexOf(v)][i] != 0) {
                Vertex<V> adj = (Vertex<V>) vertices.get(i);

                if (adj.getC() == Colors.WHITE) {
                    adj.setParent(v);
                    time = dfsInner(adj, time);
                }
            }
        }

        v.setC(Colors.BLACK);
        time += 1;
        v.setDistancefinal(time);

        return time;
    }

    public GraphAdjacencyMatrix<V> prim() {
        if (vertices.size() == 0) {
            return null;
        }
        // Estructuras auxiliares
        Set<Vertex<V>> visited = new HashSet<>();
        PriorityQueue<Map.Entry<Vertex<V>, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Vertex<V>, Integer> key = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();

        for (Vertex<V> v : vertices) {
            key.put(v, Integer.MAX_VALUE);
            parent.put(v, null);
        }
        Vertex<V> origen = vertices.get(0);
        key.put(origen, 0);
        minHeap.add(new AbstractMap.SimpleEntry<>(origen, 0));
        while (!minHeap.isEmpty()) {
            Vertex<V> u = minHeap.poll().getKey();
            visited.add(u);

            for (Map.Entry<Vertex<V>, Integer> entry : u.getAdyacentes()) {
                Vertex<V> v = entry.getKey();
                int peso = entry.getValue();

                if (!visited.contains(v) && peso < key.get(v)) {
                    key.put(v, peso);
                    parent.put(v, u);

                    // Actualizar el peso en el minHeap
                    for (Map.Entry<Vertex<V>, Integer> heapEntry : minHeap) {
                        if (heapEntry.getKey().equals(v)) {
                            minHeap.remove(heapEntry);
                            break;
                        }
                    }
                    minHeap.add(new AbstractMap.SimpleEntry<>(v, peso));
                }
            }
        }
        // Construir el árbol mínimo
        GraphAdjacencyMatrix<V> arbolMinimo = new GraphAdjacencyMatrix<>(minHeap.size());
        Map<Vertex<V>, Vertex<V>> vertexMap = new HashMap<>();

        for (Vertex<V> v : vertices) {
            Vertex<V> newVertex = new Vertex<>(v.getDato());
            arbolMinimo.agregarVertice(newVertex);
            vertexMap.put(v, newVertex);
        }

        for (Vertex<V> v : parent.keySet()) {
            Vertex<V> p = parent.get(v);
            if (p != null) {
                int peso = 0;
                for (Map.Entry<Vertex<V>, Integer> entry : p.getAdyacentes()) {
                    if (entry.getKey().equals(v)) {
                        peso = entry.getValue();
                        break;
                    }
                }
                Vertex<V> newV = vertexMap.get(v);
                Vertex<V> newP = vertexMap.get(p);
                arbolMinimo.agregarArista(newP, newV, peso);
            }
        }

        return arbolMinimo;
    }

}

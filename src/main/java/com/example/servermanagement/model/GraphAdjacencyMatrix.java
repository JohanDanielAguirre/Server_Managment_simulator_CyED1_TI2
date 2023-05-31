package com.example.servermanagement.model;

import java.util.*;

public class GraphAdjacencyMatrix<V extends Vertex<V>> implements Graph<V>{
    private int numVertices;
    private double[][] adjacencyMatrix;
    private List<V> vertices;

    public int getNumVertices() {
        return numVertices;
    }

    public double[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public List<V> getVertices() {
        return vertices;
    }

    public GraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new double[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    @Override
    public boolean remVertex(Vertex<V> vertex) {
        int vertexIndex = vertices.indexOf(vertex);
        vertices.remove(vertexIndex);
        numVertices--;

        double[][] newMatrix = new double[numVertices][numVertices];
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
    public Vertex<V> findVertex(String name) {
        for (int i = 0; i < vertices.size(); i++) {
            String dato = String.valueOf(vertices.get(i).getDato());
            if (dato.equals(name)) {
                return vertices.get(i);
            }
        }
        return null;
    }

    @Override
    public GraphListaadyacencia<V> AdjustedWeights(GraphListaadyacencia<V> g, double amountData) {
        return null;
    }

    @Override
    public ArrayList<Vertex<V>> Dijsktra(Vertex<V> start, Vertex<V> end) {
        // Initialize data structures
        Map<Vertex<V>, Double> distances = new HashMap<>();  // Stores the shortest distances from the source vertex
        Map<Vertex<V>, Vertex<V>> parents = new HashMap<>();  // Stores the previous vertex in the shortest path
        Set<Vertex<V>> visited = new HashSet<>();  // Set of visited vertices
        // Initialize distances with infinity for all vertices except the source
        for (Vertex<V> vertex : vertices) {
            distances.put(vertex, Double.MAX_VALUE);
        }
        distances.put(start, 0.0);
        // Create a minimum priority queue to store vertices based on their distances
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        priorityQueue.add(start);
        // Perform Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            // Get the vertex with the minimum distance
            Vertex<V> minVertex = priorityQueue.poll();
            if (minVertex.equals(end)) {
                break;  // Stop the algorithm if the objective vertex is reached
            }
            // Mark the current vertex as visited
            visited.add(minVertex);
            int iMin = vertices.indexOf(minVertex);
            // Update distances and parents for adjacent vertices
            for (int i = 0; i<numVertices;i++) {
                if (adjacencyMatrix[iMin][i] > 0){
                    Vertex<V> adjacentVertex = vertices.get(i);
                    double edgeWeight = adjacencyMatrix[iMin][i];
                    if (!visited.contains(adjacentVertex)) {
                        double newDistance = distances.get(minVertex) + edgeWeight;
                        if (newDistance < distances.get(adjacentVertex)) {
                            distances.put(adjacentVertex, newDistance);
                            parents.put(adjacentVertex, minVertex);
                            priorityQueue.add(adjacentVertex);  // Add the adjacent vertex to the priority queue
                        }
                    }
                }
            }
        }
        // Construct the shortest path
        ArrayList<Vertex<V>> shortestPath = new ArrayList<>();
        Vertex<V> currentVertex = end;
        // Build the path by backtracking through parents
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex);
            currentVertex = parents.get(currentVertex);
        }
        return shortestPath;
    }

    @Override
    public double[][] floydL() {
        return new double[0][];
    }

    @Override
    public GraphListaadyacencia<V> primL() {
        return null;
    }

    @Override
    public GraphListaadyacencia<V> kruskal() {
        return null;
    }

    @Override
    public void addEdge(Vertex<V> origen, Vertex<V> destino, double peso) {
        int sourceIndex = vertices.indexOf(origen);
        int destinationIndex = vertices.indexOf(destino);

        if (sourceIndex != -1 && destinationIndex != -1) {
            adjacencyMatrix[sourceIndex][destinationIndex] = peso;
            adjacencyMatrix[destinationIndex][sourceIndex] = peso;
        }
    }

    @Override
    public void addVertex(Vertex<V> vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add((V) vertice);
            numVertices++;

            double[][] newMatrix = new double[numVertices][numVertices];
            for (int i = 0; i < numVertices - 1; i++) {
                System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, numVertices - 1);
            }
            adjacencyMatrix = newMatrix;
        }
    }

    @Override
    public boolean remEdge(Vertex<V> source, Vertex<V> destination) {
        int sourceIndex = vertices.indexOf(source);
        int destinationIndex = vertices.indexOf(destination);

        if (sourceIndex != -1 && destinationIndex != -1) {
            adjacencyMatrix[sourceIndex][destinationIndex] = 0;
            adjacencyMatrix[destinationIndex][sourceIndex] = 0;
        }
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void bfs(Vertex<V> v) {
        if (vertices.size() > 0) {
            for (V vertex : vertices) {
                vertex.setC(Colors.WHITE);
                vertex.setDistance(0);
                vertex.setParent(null);
                bfsInner(v);
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
                    Vertex<V> adj = vertices.get(i);

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
    @Override
    public GraphAdjacencyMatrix<V> primM() {
        if (vertices.size() == 0) {
            return null;
        }
        // Estructuras auxiliares
        Set<Vertex<V>> visited = new HashSet<>();
        PriorityQueue<Map.Entry<Vertex<V>, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Vertex<V>, Double> key = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();

        for (Vertex<V> v : vertices) {
            key.put(v, Double.MAX_VALUE);
            parent.put(v, null);
        }
        Vertex<V> origen = vertices.get(0);
        key.put(origen, 0.0);
        minHeap.add(new AbstractMap.SimpleEntry<>(origen, 0));
        while (!minHeap.isEmpty()) {
            Vertex<V> u = minHeap.poll().getKey();
            visited.add(u);

            for (Map.Entry<Vertex<V>, Double> entry : u.getAdyacentes()) {
                Vertex<V> v = entry.getKey();
                double peso = entry.getValue();

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
                    minHeap.add(new AbstractMap.SimpleEntry<>(v, (int) peso));
                }
            }
        }
        // Construir el árbol mínimo
        GraphAdjacencyMatrix<V> arbolMinimo = new GraphAdjacencyMatrix<>(minHeap.size());
        Map<Vertex<V>, Vertex<V>> vertexMap = new HashMap<>();

        for (Vertex<V> v : vertices) {
            Vertex<V> newVertex = new Vertex<>(v.getDato());
            arbolMinimo.addVertex(newVertex);
            vertexMap.put(v, newVertex);
        }

        for (Vertex<V> v : parent.keySet()) {
            Vertex<V> p = parent.get(v);
            if (p != null) {
                double peso = 0;
                for (Map.Entry<Vertex<V>, Double> entry : p.getAdyacentes()) {
                    if (entry.getKey().equals(v)) {
                        peso = entry.getValue();
                        break;
                    }
                }
                Vertex<V> newV = vertexMap.get(v);
                Vertex<V> newP = vertexMap.get(p);
                arbolMinimo.addEdge(newP, newV, peso);
            }
        }

        return arbolMinimo;
    }


    public double[][] floydM(){

        int v = vertices.size();
        double[][] distances = new double[v][v];
        // Initialize distances with infinity for all pairs of vertices
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distances[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        // Set distance 0 for self-loops
        for (int i = 0; i < v; i++) {
            distances[i][i] = 0;
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distances[i][j] = adjacencyMatrix[i][j];
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        return distances;
    }

}

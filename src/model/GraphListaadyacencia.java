package model;

import java.util.*;

public class GraphListaadyacencia<V extends Vertex<V>> implements  Graph<V>{
    private ArrayList<Vertex<V>> vertices;
    private int time=0;

    public ArrayList<Vertex<V>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex<V>> vertices) {
        this.vertices = vertices;
    }

    public  GraphListaadyacencia() {
        vertices = new ArrayList<>();
    }
    public void agregarVertice(Vertex<V> vertice) {
        if(vertices.contains(vertice)){
            return;
        }
        if(vertice!=null){
            vertices.add(vertice);
        }
    }

    @Override
    public void agregarArista(Vertex<V> origen, Vertex<V> destino, int peso) {
        if (origen != null && destino != null) {
            for (int i = 0; i < origen.getAdyacentes().size(); i++) {
                Map.Entry<Vertex<V>,Integer> entry = (Map.Entry<Vertex<V>,Integer>) origen.getAdyacentes().get(i);
                Vertex<V> v = entry.getKey();
                if (v.equals(destino)) {
                    return;
                }
            }
            origen.getAdyacentes().add(new AbstractMap.SimpleEntry<>(destino, peso));
            destino.getAdyacentes().add(new AbstractMap.SimpleEntry<>(origen, peso));
        }
    }
    @Override
    public void bfs(Vertex<V> v) {
        if(vertices.size()>0){
            v.setC(Colors.WHITE);
            v.setDistance(0);
            v.setParent(null);
            bfsinner(v);
        }
        //String msg="";
        //msg=createtree(v);
        //return msg;
    }
    private void bfsinner(Vertex<V> v) {
        for (Vertex<V> q: vertices) {
            q.setDistance(0);
            q.setC(Colors.WHITE);
            q.setParent(null);
        }
        v.setC(Colors.GREY);
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Vertex<V> u = queue.poll();
            for (Map.Entry<Vertex<V>,Integer> entry : u.getAdyacentes()) {
                Vertex<V> adj = entry.getKey();
                if (adj.getC() == Colors.WHITE) {
                    adj.setC(Colors.GREY);
                    adj.setDistance(u.getDistance() + 1);
                    adj.setParent(u);
                    queue.add(adj);
                }
            }
            u.setC(Colors.BLACK);
        }
    }

    @Override
    public void dfs(){
        if(vertices.size()>0){
            for (Vertex<V> v:vertices) {
                v.setC(Colors.WHITE);
                v.setParent(null);
            }
            time=0;
            for (Vertex<V> v : vertices) {
                if (v.getC() == Colors.WHITE) {
                    dfs(v,time);
                }
            }
        }
    }
    private void dfs(Vertex<V> v,int t){
        time+=1;
        v.setDistance(t);
        v.setC(Colors.GREY);
        for (Map.Entry<Vertex<V>,Integer> u : v.getAdyacentes()) {
            if (u.getKey().getC()==Colors.WHITE) {
                u.getKey().setParent(v);
                dfs(u.getKey(),t);
            }
        }
        v.setC(Colors.BLACK);
        time +=1;
        v.setDistancefinal(time);
    }

    public boolean borrarArista(Vertex<V> origen, Vertex<V> destino) {
        // Verificar si los vértices existen en el grafo
        if (!vertices.contains(origen) || !vertices.contains(destino)) {
            return false;
        }
        // Buscar la arista en el vértice de origen
        Map.Entry<Vertex<V>,Integer> arista = null;
        for (Map.Entry<Vertex<V>,Integer> entry : origen.getAdyacentes()) {
            if (entry.getKey().equals(destino)) {
                arista = entry;
                break;
            }
        }
        // Verificar si la arista existe
        if (arista == null) {
            return false;
        }
        // Borrar la arista
        origen.getAdyacentes().remove(arista);
        return true;
    }
    @Override
    public boolean borrarVertice(Vertex<V> vertice) {
        if (vertice == null) {
            return false; // El vértice a eliminar es null, no se puede eliminar
        }
        if (!vertices.contains(vertice)) {
            return false; // El vértice no se encuentra en la lista de vértices, no se puede eliminar
        }
        // Eliminar todas las aristas que tienen como destino el vértice a eliminar
        for (Vertex<V> v : vertices) {
            Iterator<Map.Entry<Vertex<V>,Integer>> iterator = v.getAdyacentes().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Vertex<V>,Integer> entry = iterator.next();
                if (entry.getKey().equals(vertice)) {
                    iterator.remove();
                }
            }
        }
        // Eliminar el vértice de la lista de vértices
        vertices.remove(vertice);
        return true;
    }

    /*@Override
    public int[] Dijsktra(Vertex<V> start) {

        start.setDistance(0);//Utilizo la variable distance
        //Cree una clase tupla para no utilizar el map, pero si quieres cambialo
        PriorityQueue<Tuple<V>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Tuple::getDistance));
        //Seteo las distancias, previos y los añados a la queue
        for (Vertex<V> v:
             vertices) {

            if (v!=start){
                v.setDistance(Integer.MAX_VALUE);
            }
            v.setParent(null);
            minHeap.add(new Tuple<>(v,v.getDistance()));

        }
        //Se supone que aqui se encuentra el camino minimo, es basicamente casi lo mismo que prim
        while (!minHeap.isEmpty()){
            Vertex<V> u = minHeap.poll().getVertex();
            for (Map.Entry<Vertex<V>,Integer> v :
                    u.getAdyacentes()) {
                int dist = u.getDistance() + v.getValue();
                if(dist < v.getValue()){
                    v.getKey().setDistance(dist);
                    v.getKey().setParent(u);
                    //Aqui iria el decrease
                }
            }
        }


        //No se que retornar
        return null;
    }*/

    @Override
    public ArrayList<Vertex<V>> Dijsktra(Vertex<V> source, Vertex<V> objective) {
        // Initialize data structures
        Map<Vertex<V>, Integer> distances = new HashMap<>();  // Stores the shortest distances from the source vertex
        Map<Vertex<V>, Vertex<V>> parents = new HashMap<>();  // Stores the previous vertex in the shortest path
        Set<Vertex<V>> visited = new HashSet<>();  // Set of visited vertices
        // Initialize distances with infinity for all vertices except the source
        for (Vertex<V> vertex : vertices) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        // Create a minimum priority queue to store vertices based on their distances
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        priorityQueue.add(source);
        // Perform Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            // Get the vertex with the minimum distance
            Vertex<V> minVertex = priorityQueue.poll();
            if (minVertex.equals(objective)) {
                break;  // Stop the algorithm if the objective vertex is reached
            }
            // Mark the current vertex as visited
            visited.add(minVertex);
            // Update distances and parents for adjacent vertices
            for (Map.Entry<Vertex<V>, Integer> entry : minVertex.getAdyacentes()) {
                Vertex<V> adjacentVertex = entry.getKey();
                int edgeWeight = entry.getValue();
                if (!visited.contains(adjacentVertex)) {
                    int newDistance = distances.get(minVertex) + edgeWeight;
                    if (newDistance < distances.get(adjacentVertex)) {
                        distances.put(adjacentVertex, newDistance);
                        parents.put(adjacentVertex, minVertex);
                        priorityQueue.add(adjacentVertex);  // Add the adjacent vertex to the priority queue
                    }
                }
            }
        }
        // Construct the shortest path
        ArrayList<Vertex<V>> shortestPath = new ArrayList<>();
        Vertex<V> currentVertex = objective;
        // Build the path by backtracking through parents
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex);
            currentVertex = parents.get(currentVertex);
        }
        return shortestPath;
    }

    public double[][] floyd_Warshall(){
        int v = vertices.size();

        double[][] distances = new double[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < v; i++) {
            distances[i][i]=0;
        }

        //se necesita continuar floyd

        return distances;

    }

    public GraphListaadyacencia<V> primL() {
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

            for (Map.Entry<Vertex<V>,Integer> entry : u.getAdyacentes()) {
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
        GraphListaadyacencia<V> arbolMinimo = new GraphListaadyacencia<>();
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
                for (Map.Entry<Vertex<V>,Integer> entry : p.getAdyacentes()) {
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

    @Override
    public GraphAdjacencyMatrix<V> primM() {
        return null;
    }

    public GraphListaadyacencia<V> kruskal() {
        // Create a new graph to store the minimum spanning tree
        GraphListaadyacencia<V> minimumSpanningTree = new GraphListaadyacencia<>();

        // Create a list to store all the edges in the graph
        List<Map.Entry<Vertex<V>, Integer>> allEdges = new ArrayList<>();

        // Populate the list with all the edges from the graph
        for (Vertex<V> vertex : vertices) {
            allEdges.addAll(vertex.getAdyacentes());
        }

        // Sort the edges in non-decreasing order based on their weights
        allEdges.sort(Comparator.comparingInt(Map.Entry::getValue));

        // Create a map to keep track of the connected components
        Map<Vertex<V>, List<Vertex<V>>> connectedComponents = new HashMap<>();

        // Process each edge in the sorted order
        for (Map.Entry<Vertex<V>, Integer> edge : allEdges) {
            // Get the source and destination vertices of the edge
            Vertex<V> source = edge.getKey();
            Vertex<V> destination = edge.getKey();

            // Check if the source and destination vertices belong to different components
            List<Vertex<V>> component1 = connectedComponents.get(source);
            List<Vertex<V>> component2 = connectedComponents.get(destination);

            // If the source vertex doesn't belong to any component, create a new component for it
            if (component1 == null) {
                component1 = new ArrayList<>();
                component1.add(source);
                connectedComponents.put(source, component1);
            }

            // If the destination vertex doesn't belong to any component, create a new component for it
            if (component2 == null) {
                component2 = new ArrayList<>();
                component2.add(destination);
                connectedComponents.put(destination, component2);
            }

            // If the source and destination vertices belong to different components, merge the components
            if (!component1.equals(component2)) {
                // Add the edge to the minimum spanning tree
                minimumSpanningTree.agregarArista(source, destination, edge.getValue());

                // Merge the connected components
                component1.addAll(component2);

                // Update the component mapping for all vertices in component2
                for (Vertex<V> vertex : component2) {
                    connectedComponents.put(vertex, component1);
                }
            }
        }

        // Return the minimum spanning tree graph
        return minimumSpanningTree;
    }

    public double[][] floydL() {
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
        // Set initial distances for existing edges
        for (int i = 0; i < v; i++) {
            Vertex<V> vertex = vertices.get(i);
            for (Map.Entry<Vertex<V>, Integer> entry : vertex.getAdyacentes()) {
                Vertex<V> adj = entry.getKey();
                int weight = entry.getValue();
                int adjIndex = vertices.indexOf(adj);
                distances[i][adjIndex] = weight;
            }
        }
        // Perform Floyd-Warshall algorithm
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
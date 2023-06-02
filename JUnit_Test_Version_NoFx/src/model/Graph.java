package model;

import java.util.ArrayList;

public interface Graph<V> {
    public void addEdge(Vertex<V> source, Vertex<V> destination, double peso);
    public void addVertex(Vertex<V> vertex);
    public boolean remEdge(Vertex<V> source, Vertex<V> destination);
    public boolean remVertex(Vertex<V> vertex);
    public Vertex<V> findVertex(String name);
    public GraphListaadyacencia<V> AdjustedWeights(GraphListaadyacencia<V> g, double amountData);
    public GraphAdjacencyMatrix<V> AdjustedWeights(GraphAdjacencyMatrix<V> g, double amountData);
    public void bfs(Vertex<V> v);
    public void dfs();
    public ArrayList<Vertex<V>> Dijsktra(Vertex<V> start, Vertex<V> end);

    public double[][] floydL();

    public double[][] floydM();

    public GraphListaadyacencia<V> primL();
    public GraphAdjacencyMatrix<V> primM();

    public GraphListaadyacencia<V> kruskal();
    public GraphAdjacencyMatrix<V> kruskalM();

}

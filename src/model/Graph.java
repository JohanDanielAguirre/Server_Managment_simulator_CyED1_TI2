package model;

import java.util.ArrayList;

public interface Graph<V extends Vertex<V>> {
    public void agregarArista(Vertex<V> origen, Vertex<V> destino, int peso);
    public void bfs(Vertex<V> v);
    public void dfs();
    public void agregarVertice(Vertex<V> vertice);
    public boolean borrarArista(Vertex<V> source, Vertex<V> destination);
    public boolean borrarVertice(Vertex<V> vertex);
    public ArrayList<Vertex<V>> Dijsktra(Vertex<V> start, Vertex<V> end);

    public GraphListaadyacencia<V> primL();

    public GraphAdjacencyMatrix<V> primM();

    public GraphListaadyacencia<V> kruskalL();






}

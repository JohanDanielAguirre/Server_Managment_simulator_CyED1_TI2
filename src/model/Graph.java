package model;

import java.util.ArrayList;

public interface Graph<V> {
    public void agregarArista(Vertex<V> origen, Vertex<V> destino, int peso);
    public void bfs(Vertex<V> v);
    public void dfs();
    public void agregarVertice(Vertex<V> vertice);
    public void deleteEdge(Vertex<V> source, Vertex<V> destination);
    public boolean deleteVertex(Vertex<V> vertex);
    public int[] Dijsktra(Vertex<V> start);






}

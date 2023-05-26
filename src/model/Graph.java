package model;

public interface Graph<V> {
    public void agregarArista(Vertex origen, Vertex destino, int peso);

    public void bfs(Vertex<V> v);
    public void dfs();

    public void agregarVertice(Vertex<V> vertice);


}

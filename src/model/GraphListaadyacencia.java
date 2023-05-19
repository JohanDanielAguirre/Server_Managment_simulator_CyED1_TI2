package model;

import java.util.*;

public class GraphListaadyacencia<V> implements  Graph{
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
    public void agregarVertice(Vertex vertice) {
        if(vertices.contains(vertice)){
            return;
        }
        if(vertice!=null){
            vertices.add(vertice);
        }
    }
    @Override
    public void agregarArista(Vertex origen, Vertex destino) {

        if((origen!=null && destino!=null) ) {
            for(int i=0;i<origen.getAdyacentes().size();i++){
                Map.Entry<Vertex<V>,Integer> k= (Map.Entry<Vertex<V>, Integer>) origen.getAdyacentes().get(i);
                Vertex v= k.getKey();
                if(v.equals(destino)){
                    return;
                }
            }
            Map.Entry<Vertex<V>, Integer> v = new AbstractMap.SimpleEntry<>(destino, 0);
            Map.Entry<Vertex<V>, Integer> x = new AbstractMap.SimpleEntry<>(origen, 0);
            origen.getAdyacentes().add(v);
            destino.getAdyacentes().add(x);
        }
    }
    @Override
    public void bfs(Vertex v) {
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
        for (Vertex q: vertices) {
            q.setDistance(0);
            q.setC(Colors.WHITE);
            q.setParent(null);
        }
        v.setC(Colors.GREY);
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Vertex<V> u = queue.poll();
            for (Map.Entry<Vertex<V>, Integer> entry : u.getAdyacentes()) {
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
            for (Vertex v:vertices) {
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
        for (Map.Entry<Vertex<V>, Integer> u : v.getAdyacentes()) {
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
        Map.Entry<Vertex<V>, Integer> arista = null;
        for (Map.Entry<Vertex<V>, Integer> entry : origen.getAdyacentes()) {
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
    public boolean borrarVertice(Vertex<V> vertice) {
        if (vertice == null) {
            return false; // El vértice a eliminar es null, no se puede eliminar
        }
        if (!vertices.contains(vertice)) {
            return false; // El vértice no se encuentra en la lista de vértices, no se puede eliminar
        }
        // Eliminar todas las aristas que tienen como destino el vértice a eliminar
        for (Vertex<V> v : vertices) {
            Iterator<Map.Entry<Vertex<V>, Integer>> iterator = v.getAdyacentes().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Vertex<V>, Integer> entry = iterator.next();
                if (entry.getKey().equals(vertice)) {
                    iterator.remove();
                }
            }
        }
        // Eliminar el vértice de la lista de vértices
        vertices.remove(vertice);
        return true;
    }
}
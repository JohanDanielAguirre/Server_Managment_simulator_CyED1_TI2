package model;

import java.util.*;

public class GraphListaadyacencia<V> implements  Graph<V>{
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
    public void deleteEdge() {

    }

    @Override
    public void agregarArista(Vertex<V> origen, Vertex<V> destino, int peso) {
        if (origen != null && destino != null) {
            for (int i = 0; i < origen.getAdyacentes().size(); i++) {
                Map.Entry<Vertex<V>, Integer> entry = (Map.Entry<Vertex<V>, Integer>) origen.getAdyacentes().get(i);
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
    @Override
    public boolean deleteVertex(Vertex<V> vertice) {
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

    @Override
    public ArrayList<Vertex<V>> Dijsktra(Vertex<V> start) {

        start.setDistance(0);

        PriorityQueue<Map.Entry<Vertex<V>, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        return null;
    }

    public GraphListaadyacencia<V> prim() {
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
package com.example.servermanagement.model;

public class Tuple<V> {

    private Vertex<V> vertex;
    private int distance;

    public Tuple(Vertex<V> vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public void setVertex(Vertex<V> vertex) {
        this.vertex = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

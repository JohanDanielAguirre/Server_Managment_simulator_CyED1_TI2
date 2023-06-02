package com.example.servermanagement.controller;

import com.example.servermanagement.model.GraphAdjacencyMatrix;
import com.example.servermanagement.model.GraphListaadyacencia;
import com.example.servermanagement.model.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddConnectionController {
    @FXML
    private TextField originServer;

    @FXML
    private TextField goalServer;

    @FXML
    private TextField weight;

    private GraphListaadyacencia graph;
    private GraphAdjacencyMatrix graphM;

    @FXML
    public void onAddConnection(ActionEvent actionEvent){
        //By changing graph to graphM you can change which to use
        String origin = originServer.getText();
        String goal = goalServer.getText();
        String w = weight.getText();
        Double weigh = Double.parseDouble(w);

        Vertex v1 = graph.findVertex(origin);
        Vertex v2 = graph.findVertex(goal);

        graph.addEdge(v1, v2, weigh);

        /*
        Vertex v1 = graphM.findVertex(origin);
        Vertex v2 = graphM.findVertex(goal);

        graphM.addEdge(v1, v2, weigh);
         */
    }

    @FXML
    public void onClose(ActionEvent event) {
        Stage stage = (Stage) originServer.getScene().getWindow();
        stage.close();
    }

    public GraphListaadyacencia getGraph() {
        return graph;
    }

    public void setGraph(GraphListaadyacencia graph) {
        this.graph = graph;
    }

    public GraphAdjacencyMatrix getGraphM() {
        return graphM;
    }

    public void setGraphM(GraphAdjacencyMatrix graphM) {
        this.graphM = graphM;
    }
}

package com.example.servermanagement.controller;

import com.example.servermanagement.model.GraphAdjacencyMatrix;
import com.example.servermanagement.model.GraphListaadyacencia;
import com.example.servermanagement.model.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddServerController {

    @FXML
    private TextField serverName;
    private GraphListaadyacencia graph;
    private GraphAdjacencyMatrix graphM;

    @FXML
    public void onAddServer(ActionEvent actionEvent){
        //By changing graph to graphM you can change which to use
        String name = serverName.getText();
        graph.addVertex(new Vertex(name));
        //graphM.addVertex(new Vertex(name));
    }

    @FXML
    public void onClose(ActionEvent event) {
        Stage stage = (Stage) serverName.getScene().getWindow();
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

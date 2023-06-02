package com.example.servermanagement.controller;

import com.example.servermanagement.MainApplication;
import com.example.servermanagement.model.GraphAdjacencyMatrix;
import com.example.servermanagement.model.GraphListaadyacencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    //By changing graph to graphM you can change which to use
    private GraphListaadyacencia graph;

    private GraphAdjacencyMatrix graphM;

    @FXML
    public Canvas graphDisplay;

    private GraphicsContext gc;

    @FXML
    public void onAddServer(ActionEvent event) {
        FXMLLoader loader = MainApplication.renderView("addServer-view.fxml");
        AddServerController addServerController = loader.getController();
        addServerController.setGraph(graph);
    }

    public void onRemoveServer(ActionEvent actionEvent) {
        FXMLLoader loader = MainApplication.renderView("removeServer-view.fxml");
        RemoveServerController removeServerController = loader.getController();
        removeServerController.setGraph(graph);
    }

    public void onAddConnection(ActionEvent actionEvent) {
        FXMLLoader loader = MainApplication.renderView("addConnection-view.fxml");
        AddConnectionController addConnectionController = loader.getController();
        addConnectionController.setGraph(graph);
    }

    public void onRemoveConnection(ActionEvent actionEvent) {
        FXMLLoader loader = MainApplication.renderView("removeConnection-view.fxml");
        RemoveConnectionController removeConnectionController = loader.getController();
        removeConnectionController.setGraph(graph);
    }

    public void onCheckDataTransfer(ActionEvent actionEvent) {
        FXMLLoader loader = MainApplication.renderView("checkDataTransfer-view.fxml");
        CheckDataTransferController checkDataTransferController = loader.getController();
        checkDataTransferController.setGraph(graph);
    }

    public void draw(){

        if (!graph.getVertices().isEmpty()){

            for (int i = 0; i < graph.getVertices().size(); i++) {
                gc.setFill(Color.WHITE);
                gc.fillOval(100,100,100,100);
                System.out.println(graph.getVertices().get(i));

            }
        }

        System.out.println(10);

    }



    public GraphListaadyacencia getGraph() {
        return graph;
    }

    public void setGraph(GraphListaadyacencia graph) {
        this.graph = graph;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = graphDisplay.getGraphicsContext2D();
        GraphListaadyacencia g = new GraphListaadyacencia<>();
        this.graph = g;
    }
}
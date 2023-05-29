package com.example.servermanagement.model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Graphtest extends TestCase {
    private GraphListaadyacencia g= new GraphListaadyacencia();
    private GraphAdjacencyMatrix g1= new GraphAdjacencyMatrix(5);
    public void stage1(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex<>("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex<>("Server4"));
        g.agregarVertice(new Vertex("Server5"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1),2);
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2),4);
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(3),3);
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(2),6);
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(4),2);
        g1.agregarVertice(new Vertex("Server1"));
        g1.agregarVertice(new Vertex<>("Server2"));
        g1.agregarVertice(new Vertex("Server3"));
        g1.agregarVertice(new Vertex<>("Server4"));
        g1.agregarVertice(new Vertex("Server5"));
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),2);
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),4);
        g1.agregarArista((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(3),3);
        g1.agregarArista((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(2),6);
        g1.agregarArista((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(4),2);
    }
    public void stage2(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex("Server4"));
        g.agregarVertice(new Vertex("Server5"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1),3);
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2),7);
        g.agregarArista((Vertex) g.getVertices().get(3), (Vertex) g.getVertices().get(4),6);
        g1.agregarVertice(new Vertex("Server1"));
        g1.agregarVertice(new Vertex("Server2"));
        g1.agregarVertice(new Vertex("Server3"));
        g1.agregarVertice(new Vertex("Server4"));
        g1.agregarVertice(new Vertex("Server5"));
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),3);
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),7);
        g1.agregarArista((Vertex) g1.getVertices().get(3), (Vertex) g1.getVertices().get(4),6);
    }
    public void stage3(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex("Server4"));
        g.agregarVertice(new Vertex("Server5"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1),3);
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2),7);
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(3),4);
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(4),3);
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(2),9);
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(3),4);
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(4),1);
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(3),5);
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(4),3);
        g.agregarArista((Vertex) g.getVertices().get(3), (Vertex) g.getVertices().get(4),2);
        g.agregarVertice(new Vertex("Server1"));
        g1.agregarVertice(new Vertex("Server2"));
        g1.agregarVertice(new Vertex("Server3"));
        g1.agregarVertice(new Vertex("Server4"));
        g1.agregarVertice(new Vertex("Server5"));
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),3);
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),7);
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(3),4);
        g1.agregarArista((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(4),3);
        g1.agregarArista((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(2),9);
        g1.agregarArista((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(3),4);
        g1.agregarArista((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(4),1);
        g1.agregarArista((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(3),5);
        g1.agregarArista((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(4),3);
        g1.agregarArista((Vertex) g1.getVertices().get(3), (Vertex) g1.getVertices().get(4),2);
    }
    public void stage4(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex("Server4"));
        g.agregarVertice(new Vertex("Server5"));

        g1.agregarVertice(new Vertex("Server1"));
        g1.agregarVertice(new Vertex("Server2"));
        g1.agregarVertice(new Vertex("Server3"));
        g1.agregarVertice(new Vertex("Server4"));
        g1.agregarVertice(new Vertex("Server5"));
    }
    @Test
    public void testbfsalldisconnectlist(){
      stage4();
      g.bfs((Vertex) g.getVertices().get(0));
      Vertex v=(Vertex) g.getVertices().get(1);
      assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(2);
        assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(3);
        assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(4);
        assertEquals(Colors.WHITE,v.getC());
    }
    @Test
    public void testbfsalldisconnectmatrix(){
        stage4();
        g1.bfs((Vertex) g1.getVertices().get(0));
        Vertex v=(Vertex) g1.getVertices().get(1);
        assertEquals(Colors.WHITE,v.getC());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(Colors.WHITE,v.getC());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(Colors.WHITE,v.getC());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(Colors.WHITE,v.getC());
    }
    @Test
    public void testbfsdisconnectlist(){
        stage2();
        g.bfs((Vertex) g.getVertices().get(0));
        Vertex v=(Vertex) g.getVertices().get(1);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(0);
        assertEquals(0,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(0,v.getDistance());
    }
    @Test
    public void testbfsdisconnectmatrix(){
        stage2();
        g1.bfs((Vertex) g1.getVertices().get(0));
        Vertex v=(Vertex) g1.getVertices().get(1);
        assertEquals(1,v.getDistance());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(1,v.getDistance());
        v=(Vertex) g1.getVertices().get(0);
        assertEquals(0,v.getDistance());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(0,v.getDistance());
    }
    @Test
    public void testbfsnormallist(){
        stage1();
        g.bfs((Vertex) g.getVertices().get(3));
        Vertex v=(Vertex) g.getVertices().get(3);
        assertEquals(0,v.getDistance());
         v=(Vertex) g.getVertices().get(0);
        assertEquals(2,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(3,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(2,v.getDistance());
    }

    @Test
    public void testbfsnormalmatrix(){
        stage1();
        g1.bfs((Vertex) g1.getVertices().get(3));
        Vertex v=(Vertex) g1.getVertices().get(3);
        assertEquals(0,v.getDistance());
        v=(Vertex) g1.getVertices().get(0);
        assertEquals(2,v.getDistance());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(3,v.getDistance());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(2,v.getDistance());
    }
    @Test
    public void testbfsallconectedlist(){
        stage3();
        g.bfs((Vertex) g.getVertices().get(3));
        Vertex v=(Vertex) g.getVertices().get(3);
        assertEquals(0,v.getDistance());
        v=(Vertex) g.getVertices().get(0);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(1,v.getDistance());
    }
    @Test
    public void testbfsallconectedmatrix(){
        stage3();
        g1.bfs((Vertex) g1.getVertices().get(3));
        Vertex v=(Vertex) g1.getVertices().get(3);
        assertEquals(0,v.getDistance());
        v=(Vertex) g1.getVertices().get(0);
        assertEquals(1,v.getDistance());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(1,v.getDistance());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(1,v.getDistance());
    }
    @Test
    public void testdfsalldisconnectedlist(){
        stage4();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(2,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(10,v.getDistancefinal());
    }
    @Test
    public void testdfsalldisconnectedmatrix(){
        stage4();
        g1.dfs();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(2,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(10,v.getDistancefinal());
    }
    @Test
    public void testdfsdisconnectlist(){
        stage2();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(3,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(5,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(9,v.getDistancefinal());
    }
    @Test
    public void testdfsdisconnectmatrix(){
        stage2();
        g1.dfs();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals(3,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(5,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(9,v.getDistancefinal());
    }
    @Test
    public void testdfsnormallist(){
        stage1();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(7,v.getDistancefinal());
    }
    @Test
    public void testdfsnormalmatrix(){
        stage1();
        g1.dfs();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(7,v.getDistancefinal());
    }
    @Test
    public void testdfsallconectedlist(){
        stage3();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(7,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(6,v.getDistancefinal());
    }
    @Test
    public void testdfsallconectedmatrix(){
        stage3();
        g1.dfs();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(7,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(6,v.getDistancefinal());
    }
    @Test
    public void testdeleteedgewithotherconnectionslist(){
        stage3();
        assertEquals(true,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithotherconnectionsmatrix(){
        stage3();
        assertEquals(true,g1.borrarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithoutotherconnectionslist(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithoutotherconnectionsmatrix(){
        stage4();
        assertEquals(false,g1.borrarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgenulllist(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),null));
    }
    @Test
    public void testdeleteedgenullmatrix(){
        stage4();
        assertEquals(false,g1.borrarArista((Vertex) g1.getVertices().get(0),null));
    }
    @Test
    public void testdeletebothedgenulllist(){
        stage4();
        assertEquals(false,g.borrarArista(null,null));
    }
    @Test
    public void testdeletebothedgenullmatrix(){
        stage4();
        assertEquals(false,g1.borrarArista(null,null));
    }

    @Test
    public void testdeletevertexnulllist(){
        stage4();
        assertEquals(false,g.borrarVertice(null));
    }
    @Test
    public void testdeletevertexnullmatrix(){
        stage4();
        assertEquals(false,g1.borrarVertice(null));
    }
    @Test
    public void testdeletevertexinexistentlist(){
        stage4();
        Vertex v= new Vertex<>("la tia conchita");
        assertEquals(false,g.borrarVertice(v));
    }
    @Test
    public void testdeletevertexinexistentmatrix(){
        stage4();
        Vertex v= new Vertex<>("la tia conchita");
        assertEquals(false,g1.borrarVertice(v));
    }
    @Test
    public void testdeletevertexlist(){
        stage2();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(5,g.getVertices().size());
        assertEquals(true,g.borrarVertice(v));
        assertEquals(4,g.getVertices().size());
    }
    @Test
    public void testdeletevertexmatrix(){
        stage2();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(5,g1.getVertices().size());
        assertEquals(true,g1.borrarVertice(v));
        assertEquals(4,g1.getVertices().size());
    }
    @Test
    public void testAdd2Vertexequalslist() {
        Vertex v=new Vertex("1");
        g.agregarVertice(v);
        g.agregarVertice(v);
        assertEquals(1,g.getVertices().size());
    }
    @Test
    public void testAdd2Vertexequalsmatrix() {
        Vertex v=new Vertex("1");
        g1.agregarVertice(v);
        g1.agregarVertice(v);
        assertEquals(1,g1.getVertices().size());
    }
    @Test
    public void testAddVertexnormallist() {
        Vertex v=new Vertex("Server1");
        g.agregarVertice(v);
        v=new Vertex("Servermaster");
        g.agregarVertice(v);
        v=new Vertex("Server3");
        g.agregarVertice(v);
        assertEquals(3,g.getVertices().size());
    }
    @Test
    public void testAddVertexnormalmatrix() {
        Vertex v=new Vertex("Server1");
        g1.agregarVertice(v);
        v=new Vertex("Servermaster");
        g1.agregarVertice(v);
        v=new Vertex("Server3");
        g1.agregarVertice(v);
        assertEquals(3,g.getVertices().size());
    }
    @Test
    public void testAddVertexnulllist() {
        g.agregarVertice(null);
        assertEquals(0,g.getVertices().size());
    }
    @Test
    public void testAddVertexnullmatrix() {
        g1.agregarVertice(null);
        assertEquals(0,g1.getVertices().size());
    }

    @Test
    public void testAddedgenulllist() {
        g.agregarVertice(new  Vertex("ServerCicle"));
        g.agregarArista((Vertex) g.getVertices().get(0),null,0);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testAddedgenullmatrix() {
        g.agregarVertice(new  Vertex("ServerCicle"));
        g.agregarArista((Vertex) g1.getVertices().get(0),null,0);
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testAddsameedgelist() {
        g.agregarVertice(new  Vertex("Servermid"));
        g.agregarVertice(new  Vertex("Servernonfunctional"));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testAddsameedgematrix() {
        g.agregarVertice(new  Vertex("Servermid"));
        g.agregarVertice(new  Vertex("Servernonfunctional"));
        g.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        g.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testAddedgesnormallist() {
        g.agregarVertice(new  Vertex("Servermid"));
        g.agregarVertice(new  Vertex("Servernonfunctional"));
        g.agregarVertice(new  Vertex("Servernonfunctional2"));
        g.agregarVertice(new  Vertex("Servernonfunctional3"));
        g.agregarVertice(new  Vertex("Servernonfunctional4"));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(2),0);
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3),0);
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(4),0);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(4,v.getAdyacentes().size());
    }
    @Test
    public void testAddedgesnormalmatrix() {
        g1.agregarVertice(new  Vertex("Servermid"));
        g1.agregarVertice(new  Vertex("Servernonfunctional"));
        g1.agregarVertice(new  Vertex("Servernonfunctional2"));
        g1.agregarVertice(new  Vertex("Servernonfunctional3"));
        g1.agregarVertice(new  Vertex("Servernonfunctional4"));
        g1.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1),0);
        g1.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(2),0);
        g1.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(3),0);
        g1.agregarArista((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(4),0);
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(4,v.getAdyacentes().size());
    }

    @Test
    public void testdijkstraalldisconnectedlist() {
        stage4();
        ArrayList <Vertex> path=g.Dijsktra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        assertEquals(0,path.size());
    }
    @Test
    public void testdijkstraalldisconnectedmatrix() {
        stage4();
        ArrayList <Vertex> path=g1.Dijsktra((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1));
        assertEquals(0,path.size());
    }

    @Test
    public void testdijkstrapartialydisconnected2list() {
        stage2();
        ArrayList <Vertex> path=g.Dijsktra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3));
        assertEquals(0,path.size());
    }
    @Test
    public void testdijkstrapartialydisconnected2matrix() {
        stage2();
        ArrayList <Vertex> path=g.Dijsktra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3));
        assertEquals(0,path.size());
    }
    @Test
    public void testdijkstranormallist() {
        stage3();
        ArrayList <Vertex> path=g.Dijsktra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(4));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(0),path.get(0));
        assertEquals(g.getVertices().get(1),path.get(1));
        assertEquals(g.getVertices().get(4),path.get(2));
    }

    @Test
    public void testdijkstranormalmatrix() {
        stage3();
        ArrayList <Vertex> path=g1.Dijsktra((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(4));
        assertEquals(3,path.size());
        assertEquals(g1.getVertices().get(0),path.get(0));
        assertEquals(g1.getVertices().get(1),path.get(1));
        assertEquals(g1.getVertices().get(4),path.get(2));
    }
    @Test
    public void testdijkstranormal2list() {
        stage3();
        ArrayList <Vertex> path=g.Dijsktra((Vertex) g.getVertices().get(3),(Vertex) g.getVertices().get(1));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(3),path.get(0));
        assertEquals(g.getVertices().get(4),path.get(1));
        assertEquals(g.getVertices().get(1),path.get(2));
    }
    @Test
    public void testdijkstranormal2matrix() {
        stage3();
        ArrayList <Vertex> path=g1.Dijsktra((Vertex) g1.getVertices().get(3),(Vertex) g1.getVertices().get(1));
        assertEquals(3,path.size());
        assertEquals(g1.getVertices().get(3),path.get(0));
        assertEquals(g1.getVertices().get(4),path.get(1));
        assertEquals(g1.getVertices().get(1),path.get(2));
    }

    @Test
    public void testFloydalldisconnectedlist() {
        stage4();
        double[][] matrix=g.floydL();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][1]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][2]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][4]);

    }
    @Test
    public void testFloydalldisconnectedmatrix() {
        stage4();
        double[][] matrix=g1.floydM();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][1]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][2]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][4]);

    }

    @Test
    public void testFloydpartialydisconnected2list() {
        stage2();
        double[][] matrix=g.floydL();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][4]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][4]);

    }
    @Test
    public void testFloydpartialydisconnected2matrix() {
        stage2();
        double[][] matrix=g1.floydM();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][4]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][4]);

    }
    @Test
    public void testFloydnormallist() {
        stage3();
        double[][] matrix=g.floydL();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(0.0,matrix[1][1]);
        assertEquals(0.0,matrix[2][2]);
        assertEquals(0.0,matrix[3][3]);
        assertEquals(0.0,matrix[4][4]);
        assertEquals(3.0,matrix[0][1]);
        assertEquals(7.0,matrix[0][2]);
        assertEquals(4.0,matrix[0][3]);
        assertEquals(3.0,matrix[0][4]);
        assertEquals(3.0,matrix[1][0]);
        assertEquals(9.0,matrix[1][2]);
        assertEquals(4.0,matrix[1][3]);
        assertEquals(1.0,matrix[1][4]);
        assertEquals(7.0,matrix[2][0]);
        assertEquals(9.0,matrix[2][1]);
        assertEquals(5.0,matrix[2][3]);
        assertEquals(3.0,matrix[2][4]);
        assertEquals(4.0,matrix[3][0]);
        assertEquals(4.0,matrix[3][1]);
        assertEquals(5.0,matrix[3][2]);
        assertEquals(2.0,matrix[3][4]);
        assertEquals(3.0,matrix[4][0]);
        assertEquals(1.0,matrix[4][1]);
        assertEquals(3.0,matrix[4][2]);
        assertEquals(2.0,matrix[4][3]);
    }
    @Test
    public void testFloydnormalmatrix() {
        stage3();
        double[][] matrix=g1.floydM();;
        assertEquals(0.0,matrix[0][0]);
        assertEquals(0.0,matrix[1][1]);
        assertEquals(0.0,matrix[2][2]);
        assertEquals(0.0,matrix[3][3]);
        assertEquals(0.0,matrix[4][4]);
        assertEquals(3.0,matrix[0][1]);
        assertEquals(7.0,matrix[0][2]);
        assertEquals(4.0,matrix[0][3]);
        assertEquals(3.0,matrix[0][4]);
        assertEquals(3.0,matrix[1][0]);
        assertEquals(9.0,matrix[1][2]);
        assertEquals(4.0,matrix[1][3]);
        assertEquals(1.0,matrix[1][4]);
        assertEquals(7.0,matrix[2][0]);
        assertEquals(9.0,matrix[2][1]);
        assertEquals(5.0,matrix[2][3]);
        assertEquals(3.0,matrix[2][4]);
        assertEquals(4.0,matrix[3][0]);
        assertEquals(4.0,matrix[3][1]);
        assertEquals(5.0,matrix[3][2]);
        assertEquals(2.0,matrix[3][4]);
        assertEquals(3.0,matrix[4][0]);
        assertEquals(1.0,matrix[4][1]);
        assertEquals(3.0,matrix[4][2]);
        assertEquals(2.0,matrix[4][3]);

    }
    @Test
    public void testPrimalldisconnectlist() {
        stage4();
        GraphListaadyacencia g1=g.primL();
        assertEquals(1,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
    }
    @Test
    public void testPrimalldisconnectmatrix() {
        stage4();
        GraphAdjacencyMatrix g2=g1.primM();
        assertEquals(1,g2.getVertices().size());
        Vertex v=(Vertex) g2.getVertices().get(0);
        assertEquals("Server1",v.getDato());
    }
    @Test
    public void testPrimpartialdisconnectlist() {
        stage2();
        GraphListaadyacencia g1=g.primL();
        assertEquals(3,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testPrimpartialdisconnectmatrix() {
        stage2();
        GraphAdjacencyMatrix g11=g1.primM();
        assertEquals(3,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
    }

    @Test
    public void testPrimnormallist() {
        stage3();
        GraphListaadyacencia g1=g.primL();
        assertEquals(5,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
    }
    @Test
    public void testPrimnormalmatrix() {
        stage3();
        GraphAdjacencyMatrix g11=g1.primM();
        assertEquals(5,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
    }

    @Test
    public void testkruskalalldisconnectlist() {
        stage4();
        GraphListaadyacencia g1=g.kruskalL();
        assertEquals(5,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals("Server5",v.getDato());
    }
    @Test
    public void testkruskalalldisconnectmatrix() {
        stage4();
        GraphAdjacencyMatrix g11=g1.kruskalM();
        assertEquals(5,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        v=(Vertex) g11.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        v=(Vertex) g11.getVertices().get(4);
        assertEquals("Server5",v.getDato());
    }
    @Test
    public void testkruskaltialdisconnectlist() {
        stage2();
        GraphListaadyacencia g1=g.kruskalL();
        assertEquals(3,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testkruskaltialdisconnectmatrix() {
        stage2();
        GraphAdjacencyMatrix g11=g1.kruskalM();
        assertEquals(3,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
    }

    @Test
    public void testKruskalnormallist() {
        stage3();
        GraphListaadyacencia g1=g.kruskalL();
        assertEquals(5,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
    }
    @Test
    public void testKruskalnormalMatrix() {
        stage3();
        GraphAdjacencyMatrix g11=g1.kruskalM();
        assertEquals(5,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(3);
        assertEquals("Server4",v.getDato());
        assertEquals(1,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(4);
        assertEquals("Server5",v.getDato());
        assertEquals(2,v.getAdyacentes().size());
    }
}

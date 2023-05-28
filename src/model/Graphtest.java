package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;

public class Graphtest extends TestCase {
    private GraphListaadyacencia g= new GraphListaadyacencia();
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
    }
    public void stage3(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex("buses incorporados"));
        g.agregarVertice(new Vertex("Kantiano"));
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
    }
    public void stage4(){
        g.agregarVertice(new Vertex("Server1"));
        g.agregarVertice(new Vertex("Server2"));
        g.agregarVertice(new Vertex("Server3"));
        g.agregarVertice(new Vertex("Server4"));
        g.agregarVertice(new Vertex("Server5"));
    }
    @Test
    public void testbfsalldisconnect(){
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
    public void testbfsdisconnect(){
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
    public void testbfsnormal(){
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
    public void testbfsallconected(){
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
    public void testdfsalldisconnected(){
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
    public void testdfsdisconnect(){
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
    public void testdfsnormal(){
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
    public void testdfsallconected(){
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
    public void testdeleteedgewithotherconnections(){
        stage3();
        assertEquals(true,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithoutotherconnections(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgenull(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),null));
    }
    @Test
    public void testdeletebothedgenull(){
        stage4();
        assertEquals(false,g.borrarArista(null,null));
    }

    @Test
    public void testdeletevertexnull(){
        stage4();
        assertEquals(false,g.borrarVertice(null));
    }
    @Test
    public void testdeletevertexinexistent(){
        stage4();
        Vertex v= new Vertex<>("la tia conchita");
        assertEquals(false,g.borrarVertice(v));
    }
    @Test
    public void testdeletevertex(){
        stage2();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(5,g.getVertices().size());
        assertEquals(true,g.borrarVertice(v));
        assertEquals(4,g.getVertices().size());
    }
    @Test
    public void testAdd2Vertexequals() {
        Vertex v=new Vertex("1");
        g.agregarVertice(v);
        g.agregarVertice(v);
        assertEquals(1,g.getVertices().size());
    }
    @Test
    public void testAddVertexnormal() {
        Vertex v=new Vertex("Server1");
        g.agregarVertice(v);
        v=new Vertex("Servermaster");
        g.agregarVertice(v);
        v=new Vertex("Server3");
        g.agregarVertice(v);
        assertEquals(3,g.getVertices().size());
    }
    @Test
    public void testAddVertexnull() {
        g.agregarVertice(null);
        assertEquals(0,g.getVertices().size());
    }

    @Test
    public void testAddedgenull() {
        g.agregarVertice(new  Vertex("ServerCicle"));
        g.agregarArista((Vertex) g.getVertices().get(0),null,0);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testAddsameedge() {
        g.agregarVertice(new  Vertex("Servermid"));
        g.agregarVertice(new  Vertex("Servernonfunctional"));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1),0);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testAddedgesnormal() {
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
    public void testdijkstraalldisconnected() {
        stage4();
        ArrayList <Vertex> path=g.dijkstra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        assertEquals(0,path.size());
    }

    @Test
    public void testdijkstrapartialydisconnected2() {
        stage2();
        ArrayList <Vertex> path=g.dijkstra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3));
        assertEquals(0,path.size());
    }
    @Test
    public void testdijkstranormal() {
        stage3();
        ArrayList <Vertex> path=g.dijkstra((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(4));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(0),path.get(0));
        assertEquals(g.getVertices().get(1),path.get(1));
        assertEquals(g.getVertices().get(4),path.get(2));
    }
    @Test
    public void testdijkstranormal2() {
        stage3();
        ArrayList <Vertex> path=g.dijkstra((Vertex) g.getVertices().get(3),(Vertex) g.getVertices().get(1));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(3),path.get(0));
        assertEquals(g.getVertices().get(4),path.get(1));
        assertEquals(g.getVertices().get(1),path.get(2));
    }

    @Test
    public void testFloydalldisconnected() {
        stage4();
        ArrayList <Vertex> path=g.floyd((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        assertEquals(0,path.size());
    }

    @Test
    public void testFloydpartialydisconnected2() {
        stage2();
        ArrayList <Vertex> path=g.floyd((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3));
        assertEquals(0,path.size());
    }
    @Test
    public void testFloydnormal() {
        stage3();
        ArrayList <Vertex> path=g.floyd((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(4));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(0),path.get(0));
        assertEquals(g.getVertices().get(1),path.get(1));
        assertEquals(g.getVertices().get(4),path.get(2));
    }
    @Test
    public void testFloydnormal2() {
        stage3();
        ArrayList <Vertex> path=g.floyd((Vertex) g.getVertices().get(3),(Vertex) g.getVertices().get(1));
        assertEquals(3,path.size());
        assertEquals(g.getVertices().get(3),path.get(0));
        assertEquals(g.getVertices().get(4),path.get(1));
        assertEquals(g.getVertices().get(1),path.get(2));
    }
    @Test
    public void testPrimalldisconnect() {
        stage4();
        GraphListaadyacencia g1=g.primL();
        assertEquals(1,g1.getVertices().size());
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals("Server1",v.getDato());
    }
    @Test
    public void testPrimpartialdisconnect() {
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
    public void testPrimnormal() {
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
    public void testkruskalalldisconnect() {
        stage4();
        GraphListaadyacencia g1=g.kruskal();
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
    public void testkruskaltialdisconnect() {
        stage2();
        GraphListaadyacencia g1=g.kruskal();
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
    public void testKruskalnormal() {
        stage3();
        GraphListaadyacencia g1=g.kruskal();
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
}

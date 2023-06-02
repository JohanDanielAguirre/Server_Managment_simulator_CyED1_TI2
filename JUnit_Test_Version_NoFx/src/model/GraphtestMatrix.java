package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GraphtestMatrix extends TestCase {
    private GraphAdjacencyMatrix g1= new GraphAdjacencyMatrix(1);
    public void stage1(){
        g1.addVertex(new Vertex("Server1"));
        g1.addVertex(new Vertex<>("Server2"));
        g1.addVertex(new Vertex("Server3"));
        g1.addVertex(new Vertex<>("Server4"));
        g1.addVertex(new Vertex("Server5"));
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),2);
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),4);
        g1.addEdge((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(3),3);
        g1.addEdge((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(2),6);
        g1.addEdge((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(4),2);
    }
    public void stage2(){
        g1.addVertex(new Vertex("Server1"));
        g1.addVertex(new Vertex("Server2"));
        g1.addVertex(new Vertex("Server3"));
        g1.addVertex(new Vertex("Server4"));
        g1.addVertex(new Vertex("Server5"));
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),3);
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),7);
        g1.addEdge((Vertex) g1.getVertices().get(3), (Vertex) g1.getVertices().get(4),6);
    }
    public void stage3(){
        g1.addVertex(new Vertex("Server1"));
        g1.addVertex(new Vertex("Server2"));
        g1.addVertex(new Vertex("Server3"));
        g1.addVertex(new Vertex("Server4"));
        g1.addVertex(new Vertex("Server5"));
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(1),3);
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(2),7);
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(3),4);
        g1.addEdge((Vertex) g1.getVertices().get(0), (Vertex) g1.getVertices().get(4),3);
        g1.addEdge((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(2),9);
        g1.addEdge((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(3),4);
        g1.addEdge((Vertex) g1.getVertices().get(1), (Vertex) g1.getVertices().get(4),1);
        g1.addEdge((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(3),5);
        g1.addEdge((Vertex) g1.getVertices().get(2), (Vertex) g1.getVertices().get(4),3);
        g1.addEdge((Vertex) g1.getVertices().get(3), (Vertex) g1.getVertices().get(4),2);
    }
    public void stage4(){
        g1.addVertex(new Vertex("Server1"));
        g1.addVertex(new Vertex("Server2"));
        g1.addVertex(new Vertex("Server3"));
        g1.addVertex(new Vertex("Server4"));
        g1.addVertex(new Vertex("Server5"));
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
    public void testdfsnormalmatrix(){
        stage1();
        g1.dfs();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(2);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(3);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g1.getVertices().get(4);
        assertEquals(5,v.getDistancefinal());
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
    public void testdeleteedgewithotherconnectionsmatrix(){
        stage3();
        assertEquals(true,g1.remEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithoutotherconnectionsmatrix(){
        stage4();
        assertEquals(false,g1.remEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgenullmatrix(){
        stage4();
        assertEquals(false,g1.remEdge((Vertex) g1.getVertices().get(0),null));
    }
    @Test
    public void testdeletebothedgenullmatrix(){
        stage4();
        assertEquals(false,g1.remEdge(null,null));
    }

    @Test
    public void testdeletevertexnullmatrix(){
        stage4();
        assertEquals(false,g1.remVertex(null));
    }
    @Test
    public void testdeletevertexinexistentmatrix(){
        stage4();
        Vertex v= new Vertex("la tia conchita");
        assertEquals(false,g1.remVertex(v));
    }
    @Test
    public void testdeletevertexmatrix(){
        stage2();
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(5,g1.getVertices().size());
        assertEquals(true,g1.remVertex(v));
        assertEquals(4,g1.getVertices().size());
    }
    @Test
    public void testAdd2Vertexequalsmatrix() {
        Vertex v=new Vertex("1");
        g1.addVertex(v);
        g1.addVertex(v);
        assertEquals(1,g1.getVertices().size());
        assertEquals(Double.POSITIVE_INFINITY, g1.getAdjacencyMatrix()[0][0]);
    }
    @Test
    public void testAddVertexnormalmatrix() {
        Vertex v=new Vertex("Server1");
        g1.addVertex(v);
        v=new Vertex("Servermaster");
        g1.addVertex(v);
        v=new Vertex("Server3");
        g1.addVertex(v);
        assertEquals(3,g1.getVertices().size());
    }

    @Test
    public void testAddVertexnullmatrix() {
        g1.addVertex(null);
        assertEquals(0,g1.getVertices().size());
    }

    @Test
    public void testAddedgenullmatrix() {
        g1.addVertex(new  Vertex("ServerCicle"));
        g1.addEdge((Vertex) g1.getVertices().get(0),null,0);
        Vertex v=(Vertex) g1.getVertices().get(0);
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testAddsameedgematrix() {
        g1.addVertex(new  Vertex("Servermid"));
        g1.addVertex(new  Vertex("Servernonfunctional"));
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1),0);
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1),0);
        int counter = 0;
        for(int i = 0; i<g1.getNumVertices()-1; i++){
            if(g1.getAdjacencyMatrix()[0][i]!=0 || g1.getAdjacencyMatrix()[0][i]!=Double.POSITIVE_INFINITY){
                counter++;
            }
        }
        assertEquals(1,counter);
    }
    @Test
    public void testAddedgesnormalmatrix() {
        g1.addVertex(new  Vertex("Servermid"));
        g1.addVertex(new  Vertex("Servernonfunctional"));
        g1.addVertex(new  Vertex("Servernonfunctional2"));
        g1.addVertex(new  Vertex("Servernonfunctional3"));
        g1.addVertex(new  Vertex("Servernonfunctional4"));
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1),0);
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(2),0);
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(3),0);
        g1.addEdge((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(4),0);
        int counter = 0;
        for(int i = 0; i<g1.getNumVertices()-1; i++){
            if(g1.getAdjacencyMatrix()[0][i]!=0 || g1.getAdjacencyMatrix()[0][i]!=Double.POSITIVE_INFINITY){
                counter++;
            }
        }

        assertEquals(4,counter);
    }
    @Test
    public void testdijkstraalldisconnectedmatrix() {
        stage4();
        ArrayList <Vertex<Integer>> path=g1.Dijsktra((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(1));
        assertEquals(1,path.size());
    }
    @Test
    public void testdijkstrapartialydisconnected2matrix() {
        stage2();
        ArrayList <Vertex> path=g1.Dijsktra((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(3));
        assertEquals(0,path.size());
    }

    @Test
    public void testdijkstranormalmatrix() {
        stage3();
        ArrayList <Vertex> path=g1.Dijsktra((Vertex) g1.getVertices().get(0),(Vertex) g1.getVertices().get(4));
        assertEquals(2,path.size());
        assertEquals(g1.getVertices().get(0),path.get(0));
        assertEquals(g1.getVertices().get(4).toString(),path.get(1).toString());

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
    public void testFloydpartialydisconnected2matrix() {
        stage2();
        double[][] matrix=g1.floydM();
        assertEquals(0.0,matrix[0][0]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][4]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[0][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][3]);
        assertEquals(Double.POSITIVE_INFINITY,matrix[1][4]);

    }

    @Test
    public void testFloydnormalmatrix() {
        stage3();
        double[][] matrix=g1.floydM();
        assertEquals(0.0,matrix[0][0]);
        assertEquals(0.0,matrix[1][1]);
        assertEquals(0.0,matrix[2][2]);
        assertEquals(0.0,matrix[3][3]);
        assertEquals(0.0,matrix[4][4]);
        assertEquals(3.0,matrix[0][1]);
        assertEquals(6.0,matrix[0][2]);
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
    public void testPrimalldisconnectmatrix() {
        stage4();
        GraphAdjacencyMatrix g2=g1.primM();
        assertEquals(5,g2.getVertices().size());
        Vertex v=(Vertex) g2.getVertices().get(0);
        assertEquals("Server1",v.getDato());
    }
    @Test
    public void testPrimpartialdisconnectmatrix() {
        stage2();
        GraphAdjacencyMatrix g11=g1.primM();
        assertEquals(5,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(0,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(1);
        assertEquals("Server2",v.getDato());
        assertEquals(0,v.getAdyacentes().size());
        v=(Vertex) g11.getVertices().get(2);
        assertEquals("Server3",v.getDato());
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testPrimnormalmatrix() {
        stage3();
        GraphAdjacencyMatrix g11=g1.primM();
        assertEquals(5,g11.getVertices().size());
        Vertex v=(Vertex) g11.getVertices().get(0);
        assertEquals("Server1",v.getDato());
        assertEquals(0,v.getAdyacentes().size());
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

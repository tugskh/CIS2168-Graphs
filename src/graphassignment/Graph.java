/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphassignment;

import edu.uci.ics.jung.graph.SparseGraph;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    
    private int v;
    private LinkedList<Integer> adj[];
    private boolean visited[];
        
        public Graph(int v){
            visited = new boolean[v];
            this.v = v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; i++){
                adj[i] = new LinkedList();
            }
        }
        
        public void addEdge(int v, int b){
            adj[v].add(b);
        }
        
        public void BreadthFirst(int s){
            LinkedList<Integer> queue = new LinkedList();
            visited[s] = true;
            queue.add(s);
            
            while (!queue.isEmpty()){
                s = queue.poll();
                System.out.println(s);
                Iterator<Integer> i = adj[s].listIterator();
                while(i.hasNext()){
                    int n = i.next();
                    if(!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            } 
        }
        
        public void DepthFirst(int v){
            visited[v] = true;
            System.out.println(v);
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int adj = i.next();
                if(!visited[adj]){
                    DepthFirst(adj);
                }
            }
        }
        
        public void topologicalSort(int v, boolean visited[], Stack<Integer> stack){
            visited[v] = true;
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int adj = i.next();
                if(!visited[adj]){
                    topologicalSort(adj, visited, stack);
                }
            }
            stack.push(v);
        }
        
        public void topologicalSort(){
            Stack<Integer> stack = new Stack<Integer>();
            visited = new boolean[v];
            for(int i = 0; i < v; i++){
                visited[i] = false;
            }
            for (int i = 0; i < v; i++) {
                if(visited[i] == false){
                    topologicalSort(i, visited, stack);
                }
            }
            while(!stack.empty()){
                System.out.print(stack.pop()+ " ");
            }
        }
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        
        
        
        Graph g = new Graph(6);
        
        
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        
        
        //g.BreadthFirst(2);
        //g.DepthFirst(2);
        //System.out.println(g.adj.toString());
        
        
    }
    
}

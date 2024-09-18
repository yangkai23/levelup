package com.algoprep.lu.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };
        List<List<Integer>> lists = listRepresentation(graph);
        System.out.println(lists);
        bfs(lists, 0);

    }

    private static void bfs(List<List<Integer>> graph, int i) {
        boolean[] visited =new boolean[graph.size()];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        visited[i]=true;
        while(!queue.isEmpty()){
            for(int val: graph.get(queue.peek())){
                if(!visited[val]){
                    queue.add(val);
                    visited[val]=true;
                }
            }
            System.out.println(queue.poll());
        }

    }

    public static List<List<Integer>> listRepresentation(int[][] graph) {
       List<List<Integer>> list = new ArrayList<>();
       for(int i=0;i<graph.length;i++) {
          list.add(new ArrayList<>());
       }
       for(int i=0;i<graph.length;i++) {
           for(int j=0;j<graph[i].length;j++) {
               if(graph[i][j]==1)
             list.get(i).add(j);
           }
       }
       return list;
    }
}

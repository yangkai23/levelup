package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 07/11/25
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0},{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int adj : adjList.get(i)) {
                inDegree[adj]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        if (q.isEmpty())
            return false;
        List<Integer> resultTopo = new ArrayList<>();
        while (!q.isEmpty()) {
            int polled = q.poll();
            resultTopo.addLast(polled);
            for (int adj : adjList.get(polled)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        return resultTopo.size() == numCourses;

    }
}

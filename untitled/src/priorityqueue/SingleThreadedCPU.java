package priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[][] allTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            allTasks[i][0] = i;
            allTasks[i][1] = tasks[i][0];
            allTasks[i][2] = tasks[i][1];
        }
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2] == 0 ? a[0] - b[0] : a[2] - b[2]);
        Arrays.sort(allTasks, Comparator.comparingInt(a -> a[1]));
        int i = 0;
        int index = 0;
        int curTime = 0;
        int[] result = new int[tasks.length];
        while (i < tasks.length) {
            while (i < tasks.length && curTime >= allTasks[i][1]) {
                minHeap.add(allTasks[i++]);
            }
            if (minHeap.isEmpty()) {
                curTime = allTasks[i][1];
            }
            if (!minHeap.isEmpty()) {
                int[] curTask = minHeap.poll();
                result[index++] = curTask[0];
                curTime += curTask[2];
            }
        }
        while (!minHeap.isEmpty()) {
            int[] curTask = minHeap.poll();
            result[index++] = curTask[0];
        }
        return result;
    }

}

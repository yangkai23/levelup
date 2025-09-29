package greedy;

import java.util.*;

public class MaximumProfitInJobScheduling {
    class Job {
        int startTime;
        int endTime;
        int profit;

        Job(int st, int et, int p) {
            this.startTime = st;
            this.endTime = et;
            this.profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(a -> a.endTime));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for (Job job : jobs) {
            Integer endTillStartTime = map.floorKey(job.startTime);
            int maxProfitTillNow = Objects.isNull(endTillStartTime) ? 0 : map.get(endTillStartTime);
            ans = Math.max(ans, maxProfitTillNow + job.profit);
            map.put(job.endTime, ans);

        }
        return ans;
    }
}

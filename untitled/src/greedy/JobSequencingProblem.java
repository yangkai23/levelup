package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh
 * @since 18/11/25
 */
public class JobSequencingProblem {
    public static void main(String[] args) {
        int[] deadline={4, 1, 1, 1};
        int[] profit={20, 10, 40, 30};
        System.out.println(jobSequencing(deadline,profit));
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n=deadline.length;
        Job[] jobs=new Job[n];
        for(int i=0;i<n;i++){
            jobs[i]= new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt((Job a)-> a.prf).reversed());
        int maxDeadline=Integer.MIN_VALUE;
        for(int val:deadline){
            maxDeadline=Math.max(maxDeadline,val);
        }

        int[] jobsDone=new int[maxDeadline+1];

        Arrays.fill(jobsDone,-1);

        int maxProfit=0;
        int maxJobs=0;

        for(int i=0;i<n;i++){
            for(int j=jobs[i].dl;j>0;j--){
                if(jobsDone[j]==-1){
                    jobsDone[j]=jobs[i].dl;
                    maxProfit+=jobs[i].prf;
                    maxJobs++;
                    break;
                }
            }
        }

        return new ArrayList<>(List.of(maxJobs,maxProfit));
    }
    static class Job{
        int dl;
        int prf;

        Job(int dl,int prf){
            this.dl=dl;
            this.prf=prf;
        }
    }
}

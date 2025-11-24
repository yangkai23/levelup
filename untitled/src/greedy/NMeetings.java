package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh
 * @since 18/11/25
 */
public class NMeetings {
    public static void main(String[] args) {
        int[] start = {1, 2};
        int[] end = {100, 99};
        System.out.println(maxMeetings(start, end));
    }

    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));
        int numOfMeets = 1;
        int lastEndTime = meetings[0].end;
        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEndTime) {
                numOfMeets++;
                lastEndTime = meetings[i].end;
            }

        }
        return numOfMeets;
    }

}

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

package leetcode.daily;

public class MinOpsToMoveBalls {
    public static void main(String[] args) {

    }
    public int[] minOperations(String boxes) {
        if(boxes==null || boxes.trim().isEmpty())
            return new int[0];
        int n=boxes.length();
        int[] prefix1s=new int[n];
        int[] suffix1s=new int[n];
        computePrefix1s(prefix1s,boxes);
        computeSuffix1s(suffix1s,boxes);
        return null;
    }

    private void computeSuffix1s(int[] suffix1s, String boxes) {

    }

    private void computePrefix1s(int[] prefix1s, String boxes) {
        for (int i=0;i<prefix1s.length;i++){
            //input:110
            //0,1,2
            //1,0,0
        }
    }
}

package slidingwindow;

/**
 * @author Anirudh
 * @since 17/11/25
 */
public class NumberOfSubstringsWithOnly1s {
    public static void main(String[] args) {
        System.out.println(numSub("111111"));
    }
    public static int numSub(String s) {
        int n=s.length();
        int MOD = 1_000_000_007;
        long ones=0;
        long result=0;
        for(int i=0;i<n;i++){
            int num=s.charAt(i)-'0';
            if(num==0 && ones!=0){
                result+=(ones*(ones+1))/2;
                ones=0;
            }else if(num==1){
                ones++;
            }
        }
        result+=(ones*(ones+1))/2;
        return (int)(result % MOD + MOD) % MOD;
    }
}

package binarysearch;

/**
 * @author Anirudh
 * @since 15/10/25
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(25));
    }
    public static int mySqrt(int x) {
        long low=1;
        long high=x;
        long result=0;
        while(low<=high){
            long mid=(low+high)/2;
            if(mid*mid <=x){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }


        }
        return (int)result;
    }
}

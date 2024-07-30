package leetcode.daily;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] ar={-1,1,-6,4,5,-6,1,4,1};
        sort(ar,0,ar.length);
        System.out.println(Arrays.toString(ar));
    }

    private static void sort(int[] ar, int start, int end) {
        if(end-start<2){
            return;
        }
        int mid=(start+end)/2;
        sort(ar,start,mid);
        sort(ar,mid,end);
        merge(ar,start,mid,end);
    }

    private static void merge(int[] ar, int start, int mid, int end) {
        if(ar[mid-1]<=ar[mid]){
            return;
        }
        int i=start;
        int j=mid;
        int temp[]=new int[end-start];
        int pos=0;
        while(i<mid && j<end){
            temp[pos++]=ar[i]<ar[j]?ar[i++]:ar[j++];
        }
        System.arraycopy(ar, i, ar, start+pos, mid-i);
        System.arraycopy(temp, 0, ar, start,pos );
    }


}

package leetcode.problemlist;

public class FirstOccurrenceString {
    public static void main(String[] args) {
        String haystack="sadbutsad";
        String needle="sad";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return -1;
        if(needle.length()>haystack.length())
            return -1;
        int index=-1;
        int needleLength=needle.length();
        for(int i=needleLength-1;i<haystack.length();i++){
            if(haystack.substring(i-needleLength+1,i+1).equals(needle)){
                index=i-needleLength+1;
                break;
            }

        }
        return index;
    }
}

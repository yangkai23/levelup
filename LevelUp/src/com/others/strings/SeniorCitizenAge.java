package com.others.strings;

import java.util.Arrays;

public class SeniorCitizenAge {
    public long getAgeCount(String[] details){
//       return Arrays.stream(ar).map(val -> val.substring(11, 13)).filter(age -> Integer.parseInt(age) > 60).count();
        int count=0;
        int len=details.length;
        for(int i=0;i<len;i++){
            String id=details[i];
            int tens=(id.charAt(11)-'0')*10;
            int ones=id.charAt(12)-'0';
            if((tens+ones)>60)
                count++;
        }
        return count;
    }
}

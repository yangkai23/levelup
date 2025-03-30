package com.others;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IoTaskContains {
    public static void main(String[] args) {
        try{
            List<String> list= Files.readAllLines(Paths.get("C:\\cps\\provider_setup\\Tsinghua\\file.txt"));
            String efsContent=Files.readString(Paths.get("C:\\cps\\provider_setup\\Tsinghua\\filterchain\\Tsin.xml"));
            Set<String> notAvailable = list.stream().filter(value -> !efsContent.contains(value)).collect(Collectors.toSet());
            notAvailable.forEach(System.out::println);
        }catch (Exception e){
          //
        }
    }
}

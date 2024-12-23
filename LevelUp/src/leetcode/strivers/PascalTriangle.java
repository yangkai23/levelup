package leetcode.strivers;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        for (int line = 1; line <= numRows; line++) {
            for (int j = 0; j <= numRows - line; j++) {
                System.out.print(" ");
            }
            int k = 1;
            List<Integer> innerList = new LinkedList<>();
            for (int i = 1; i <= line; i++) {
                innerList.add(k);
                k = k * (line - i) / i;
            }
            System.out.println();
            list.add(innerList);
        }
        return list;
    }
}

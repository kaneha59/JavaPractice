package junit测试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer intArray;
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        String[] strs = null;
        while(sc.hasNext()) {
            String oneLine = sc.nextLine();
            strs = oneLine.split(",");
        }

        for (int i = 0; i < strs.length; i++) {
            Integer.getInteger(strs[i]);
            intArray = Integer.valueOf(strs[i]);
            if(intArray % 2 != 0) {
                oneList.add(intArray);
            } else {
                twoList.add(intArray);
            }
        }
        oneList.addAll(twoList);
        System.out.println(oneList);
    }
}

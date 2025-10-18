import java.util.*;

public class ArrayListTestcases {
    public static void main(String[] args) {
        /*
        ArrayList testcase
         */
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);  // [1]
        list.add(2);  // [1, 2]
        list.addLast(5);  // [1, 2, 5]
        list.addFirst(3);  // [3, 1, 2, 5]

        System.out.println(list.get(0));  // 3
        System.out.println(list.contains(5)); // true

        list.remove(3); // [3, 1, 2]

        System.out.println(list.contains(5)); // false
        System.out.println(list);
    }
}
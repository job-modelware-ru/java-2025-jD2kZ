import java.util.*;

public class LinkedListTestcases {
    public static void main(String[] args) {
        /*
        LinkedList testcase
         */
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1); // 1
        list.add(2); // 1 -> 2
        list.add(1, 3); // 1 -> 3 -> 2
        list.remove(2); // 1 -> 3
        System.out.println(list);
    }
}
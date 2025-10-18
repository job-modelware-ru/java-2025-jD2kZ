import java.util.HashSet;


public class HashSetTestcases {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("apple"); // {apple}
        set.add("banana"); // {apple, banana}
        set.add("cherry"); // {apple, banana, cherry}

        System.out.println(set.contains("apple")); // true

        set.add("apple"); // {apple, banana, cherry}

        System.out.println(set.contains("jojo")); // false
    }
}

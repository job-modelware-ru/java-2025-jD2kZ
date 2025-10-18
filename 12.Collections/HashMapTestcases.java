import java.util.HashMap;

public class HashMapTestcases {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "apple"); // {1: apple}
        map.put("2", "cherry"); // {1: apple, 2: cherry}

        map.put("1", "banana"); // {1: banana, 2: cherry}

        System.out.println(map.get("1")); // banana
        System.out.println(map.get("42")); // null
    }
}

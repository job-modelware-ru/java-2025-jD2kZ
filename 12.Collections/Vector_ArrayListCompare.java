import java.util.*;

public class Vector_ArrayListCompare {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();

        final int arraySize = 300_000_000;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; ++i) {
            arrayList.add(1);
        }

        System.out.println("ArrayList: timeMs - " + (System.currentTimeMillis() - startTime));
        arrayList.clear();

        startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; ++i) {
            vector.add(1);
        }

        System.out.println("Vector: timeMs - " + (System.currentTimeMillis() - startTime));
        vector.clear();
    }
}
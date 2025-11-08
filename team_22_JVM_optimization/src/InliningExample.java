public class InliningExample {
    private int value = 7;

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        InliningExample obj = new InliningExample();
        int val = 0;
        for (int i = 0; i < 1_000_000; i++) {
            val = obj.getValue(); //нет вызова метода
        }
        System.out.println(val);
    }
}

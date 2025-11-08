
public class ConstantFolding {

    public static void main(String[] args) {
        for(int i=0;i<20000;i++) {
            test();
        }
    }

    public static void test() {
        int x = 100;
        int y = x * 2 + 5; // = 205
        System.out.println(y);
    }
}

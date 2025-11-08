public class LoopUnrolling {

    static void test() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += 1;
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        for(int i=0;i<100000;i++) {
            test();
        }
    }
}

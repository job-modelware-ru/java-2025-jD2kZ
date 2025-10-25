public class race_condition_example {

    static int i = 0;

    public static void main(String[] args) throws Exception {

        Runnable func = () -> {
            for (int j = 0; j < 1000; j++) {
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread a = new Thread(func);
        Thread b = new Thread(func);

        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println(i); //not 2000
    }
}

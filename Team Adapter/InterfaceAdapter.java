interface BigInterface {
    void a(); void b(); void c();
}

abstract class BigInterfaceAdapter implements BigInterface {
    @Override public void a() {}
    @Override public void b() {}
    @Override public void c() {}
}

class MyListener extends BigInterfaceAdapter {
    @Override public void b() {
        System.out.println("реализована только b()");
    }
}
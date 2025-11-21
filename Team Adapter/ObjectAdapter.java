interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Вызван метод Adaptee.specificRequest()");
    }
}

class Adapter implements Target {
    private final Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapter.request() -> транслирует вызов в...");
        adaptee.specificRequest();
    }
}

class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        adapter.request();
    }
}
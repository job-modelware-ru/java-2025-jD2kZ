interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Вызвын метод Adaptee.specificRequest()");
    }
}

class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("ClassAdapter.request() -> напрямую вызывает specificRequest()");
        specificRequest();
    }
}

class ClientClassAdapter {
    public static void main(String[] args) {
        Target adapter = new ClassAdapter();
        adapter.request();
    }
}
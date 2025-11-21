interface Target {
    void request();
}
interface IAdaptee {
    void specificRequest();
}
class Adaptee implements IAdaptee {
    public void specificRequest() {
        System.out.println("Adaptee.specificRequest()");
    }
}
class TwoWayAdapter implements Target, IAdaptee {
    private final Target targetSide;
    private final IAdaptee adapteeSide;
    public TwoWayAdapter(Target t) {this.targetSide = t; this.adapteeSide = null; }
    public TwoWayAdapter(IAdaptee a) {this.adapteeSide = a; this.targetSide = null; }
    @Override
    public void request() {
        if (adapteeSide != null) {
            System.out.println("TwoWayAdapter.request() -> вызывает specificRequest()");
            adapteeSide.specificRequest();
        } else {
            System.out.println("TwoWayAdapter.request() -> targetSide.request()");
            targetSide.request();
        }
    }
    @Override
    public void specificRequest() {
        if (targetSide != null) {
            System.out.println("TwoWayAdapter.specificRequest() -> вызывает targetSide.request()");
            targetSide.request();
        } else {
            adapteeSide.specificRequest();
        }
    }
}
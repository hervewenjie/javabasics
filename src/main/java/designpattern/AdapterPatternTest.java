package designpattern;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class AdapterPatternTest {
}

// client requested
interface Target {
    void request();
}

// already there
class Adaptee {
    void specificRequest() {}
}

class Adapter implements Target {

    private Adaptee adaptee;

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
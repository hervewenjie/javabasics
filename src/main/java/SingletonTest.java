/**
 * Created by chengwenjie on 2018/12/6.
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton s = Singleton.newInstance();
    }

}

class Singleton {

    static Singleton s;

    private Singleton() {}

    static Singleton newInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}

class DoubleCheckSingleton {
    static DoubleCheckSingleton dcs;

    private DoubleCheckSingleton() {}

    static DoubleCheckSingleton newInstance() {
        if (dcs == null) {
            synchronized (DoubleCheckSingleton.class) {
                // still need to check after get lock
                // because ... apparently
                if (dcs == null) {
                    dcs = new DoubleCheckSingleton();
                }
            }
        }
        return dcs;
    }
}
import java.util.concurrent.locks.LockSupport;

/**
 * Created by chengwenjie on 2018/12/4.
 */
public class ParkTest {

    public static void main(String[] args) {
        System.out.println("before");
        LockSupport.park();
        System.out.println("after");
    }
}

package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class DefaultGCTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            list.add(new byte[1024]);
        }
    }
}

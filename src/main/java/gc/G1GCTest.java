package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class G1GCTest {

    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        while (true) {
            list.add(new byte[1024]);
        }
    }
}

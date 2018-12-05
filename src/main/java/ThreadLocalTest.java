/**
 * Created by chengwenjie on 2018/12/4.
 */
public class ThreadLocalTest {

    ThreadLocal<Long> tli = ThreadLocal.withInitial(() -> 999L);

    public static void main(String[] args) throws Exception {
        ThreadLocalTest test = new ThreadLocalTest();
        System.out.println(String.format("Integer in thread %d value %d", Thread.currentThread().getId(), test.tli.get()));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                test.tli.set(Thread.currentThread().getId());
                System.out.println(String.format("Integer in thread %d value %d", Thread.currentThread().getId(), test.tli.get()));
            }).start();
        }

        Thread.sleep(5000);
        System.out.println(String.format("Integer in thread %d value %d", Thread.currentThread().getId(), test.tli.get()));
    }

}

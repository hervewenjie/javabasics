import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chengwenjie on 2018/12/4.
 */
public class ClhSpinLock {

    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public ClhSpinLock() {
        this.node = ThreadLocal.withInitial(() -> new Node());
        this.prev = ThreadLocal.withInitial(() -> null);
    }

    public void lock() {
        // get current thread's node
        final Node node = this.node.get();
        // set current thread's node to locked
        node.locked = true;
        // i become tail, get tail, wait for tail to release lock
        Node pred = this.tail.getAndSet(node);
        this.prev.set(pred);
        while (pred.locked) { // spin
        }
    }

    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }

    private static class Node {
        private volatile boolean locked;
    }

    public static void main(String[] args) throws Exception {

        final ClhSpinLock lock = new ClhSpinLock();

        lock.lock();
        System.out.println("main thread lock!");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                lock.lock();
                System.out.println(Thread.currentThread().getId() + " acquired the lock!");
                lock.unlock();

            }).start();
            Thread.sleep(100);
        }

        System.out.println("main thread unlock!");
        lock.unlock();
    }

}

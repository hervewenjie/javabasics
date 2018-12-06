package lock;

import java.util.concurrent.TimeUnit;

/**
 * Created by chengwenjie on 2018/12/6.
 */
public class CountDownLatch {

    private static final class Sync extends java.util.concurrent.locks.AbstractQueuedSynchronizer {

        private static final long serialVersionUID = 4982264981922014374L;

        Sync(int count) { setState(count); }

        int getCount() { return getState(); }

        protected int tryAcquireShared(int acquires) { return (getState() == 0) ? 1 : -1; }

        protected boolean tryReleaseShared(int releases) {
            for (;;) {
                int c = getState();
                if (c == 0) return false;
                int nextc = c - 1;
                if (compareAndSetState(c, nextc)) return nextc == 0;
            }
        }

    }

    private final Sync sync;

    public CountDownLatch(int count) {
        if (count < 0) throw new IllegalMonitorStateException();
        this.sync = new Sync(count);
    }

    public void await() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    public void countDown() {
        sync.releaseShared(1);
    }

}

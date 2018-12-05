package lock;

import java.util.concurrent.locks.*;

/**
 * Created by chengwenjie on 2018/12/5.
 */
public class TwinsLock {

    private static final class Sync extends java.util.concurrent.locks.AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count <= 0) throw new IllegalMonitorStateException();
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;

                if (newCount < 0 || compareAndSetState(current, newCount)) return newCount;
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) return true;
            }
        }
    }
}

package lock;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * Created by chengwenjie on 2018/12/5.
 */
public class Mutex implements Lock {

    private static class Sync extends java.util.concurrent.locks.AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            // try to set 0 to 1
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) { throw new IllegalMonitorStateException(); }
            // many threads to lock
            // but only one to unlocks
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() { return new ConditionObject(); }

        public void printQueuedThread() {
            Collection<Thread> list = getQueuedThreads();
            list.stream().forEach(t -> System.out.println(t));
        }
    }

    private final Sync sync = new Sync();

    public void print() { sync.printQueuedThread(); }

    @Override
    public void lock() { sync.acquire(1); }

    @Override
    public void lockInterruptibly() throws InterruptedException {}

    @Override
    public boolean tryLock() { return false; }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException { return false; }

    @Override
    public void unlock() { sync.release(1); }

    @Override
    public Condition newCondition() { return null; }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 before park");
            LockSupport.park();
            System.out.println("t1 after park");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 before unpark t1");
            LockSupport.unpark(t1);
            System.out.println("t2 after unpark t1");
        });

        t1.start();
        t2.start();
    }

}

package lock;

/**
 * Created by chengwenjie on 2018/12/5.
 */
public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {

    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * empty constructor used by subclasses
     */
    protected AbstractOwnableSynchronizer() { }

    /**
     * current owner of exclusive mode
     */
    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

}

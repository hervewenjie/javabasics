package execute;

/**
 * Future that is runnable
 *
 * Created by chengwenjie on 2018/12/6.
 */
public interface RunnableFuture<V> extends Runnable, Future<V> {

    void run();
}

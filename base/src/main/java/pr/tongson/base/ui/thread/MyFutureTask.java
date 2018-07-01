package pr.tongson.base.ui.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <b>Create Date:</b> 2018/6/8<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
public class MyFutureTask extends FutureTask<Object>{
    public MyFutureTask(@NonNull Callable<Object> callable) {
        super(callable);
    }
}

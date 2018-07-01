package pr.tongson.lib.dsa.queue;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class ExceptionQueueFull extends RuntimeException {
    public ExceptionQueueFull(String err) {
        super(err);
    }
}

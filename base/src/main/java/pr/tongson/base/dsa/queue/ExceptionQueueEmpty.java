package pr.tongson.base.dsa.queue;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class ExceptionQueueEmpty extends RuntimeException {
    public ExceptionQueueEmpty(String err) {
        super(err);
    }
}

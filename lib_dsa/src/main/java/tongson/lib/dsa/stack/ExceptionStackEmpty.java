package tongson.lib.dsa.stack;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 当试图对空栈应用pop或top方法时，本意外将被抛出 <br>
 *
 * @author tongs
 */
public class ExceptionStackEmpty extends RuntimeException{
    public ExceptionStackEmpty(String err) {
        super(err);
    }
}

package pr.tongson.pattern3.State.tcp;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public interface TcpState {
    void open();
    void close();
    void acknowledge();
}

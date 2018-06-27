package pr.tongson.base.dsa.linkedlist;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface Position {

    /**
     * 返回存放于该位置的元素
     *
     * @return 存放于该位置的元素
     */
    Object getElem();


    /**
     * 将给定元素存放至该位置，返回此前存放的元素
     *
     * @param e
     * @return 此前存放的元素
     */
    Object setElem(Object e);
}

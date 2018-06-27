package pr.tongson.base.dsa.iterator;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface Iterator {
    boolean hasNext();//检查迭代器中是否还有剩余的元素

    Object getNext();//返回迭代器中的下一元素
}

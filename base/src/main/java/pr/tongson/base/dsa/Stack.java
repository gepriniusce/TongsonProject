package pr.tongson.base.dsa;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 栈接口 <br>
 *
 * @author tongs
 */
public interface Stack {
    /**
     * 返回栈中元素数目* /
     * int getSize();
     * <p>
     * /**判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 取栈顶元素（但不删除）
     */
    Object top() throws ExceptionStackEmpty;

    /**
     * 入栈
     */
    void push(Object ele);

    /**
     * 出栈
     */
    Object pop() throws ExceptionStackEmpty;
}

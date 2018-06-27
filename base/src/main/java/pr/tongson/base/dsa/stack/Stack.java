package pr.tongson.base.dsa.stack;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>
 * 栈是存放对象的一种特殊容器，
 * 在插入与删除对象时，
 * 这种结构遵循后进先出（Last-in-first-out，LIFO）的原则 <br>
 *
 * @author tongs
 */
public interface Stack {
    /**
     * @return 返回栈中元素数目
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();


    /**
     * 取栈顶元素（但不删除）
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    Object top() throws ExceptionStackEmpty;

    /**
     * 入栈
     *
     * @param ele
     */
    void push(Object ele);

    /**
     * 出栈
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    Object pop() throws ExceptionStackEmpty;
}

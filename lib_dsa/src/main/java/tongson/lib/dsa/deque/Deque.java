package tongson.lib.dsa.deque;

import pr.tongson.base.dsa.queue.ExceptionQueueEmpty;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface Deque {
    /**
     * 返回队列中元素数目
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 取首元素
     * （但不删除）
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object first() throws ExceptionQueueEmpty;

    /**
     * 取末元素
     * （但不删除）
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object last() throws ExceptionQueueEmpty;

    /**
     * 将新元素作为首元素插入
     *
     * @param obj
     */
    void insertFirst(Object obj);

    /**
     * 将新元素作为末元素插入
     *
     * @param obj
     */
    void insertLast(Object obj);

    /**
     * 删除首元素
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object removeFirst() throws ExceptionQueueEmpty;

    /**
     * 删除末元素
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object removeLast() throws ExceptionQueueEmpty;

    /**
     * 遍历
     */
    void Traversal();
}

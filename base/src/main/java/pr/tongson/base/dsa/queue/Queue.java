package pr.tongson.base.dsa.queue;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>
 * 队列的抽象数据类型就是一个容器，
 * 其中的对象排成一个序列，
 * 我们只能访问和取出排在最前端（Front）的对象，
 * 只能在队列的尾部（Rear）插入新对象。
 * 正是按照这一规则，才能保证最先被插入的对象首先被删除（FIFO）。 <br>
 *
 * @author tongs
 */
public interface Queue {

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
     * 取队首元素（但不删除）
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object front() throws ExceptionQueueEmpty;


    /**
     * 入队
     *
     * @param obj
     * @throws ExceptionQueueFull
     */
    void enqueue(Object obj) throws ExceptionQueueFull;


    /**
     * 出队
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    Object dequeue() throws ExceptionQueueEmpty;

    /**
     * 遍历
     */
    void Traversal();
}

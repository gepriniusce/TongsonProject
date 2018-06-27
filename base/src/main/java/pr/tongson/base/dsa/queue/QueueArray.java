package pr.tongson.base.dsa.queue;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class QueueArray implements Queue {

    /**
     * 数组的默认容量
     */
    public static final int CAPACITY = 1000;
    /**
     * 数组的实际容量
     */
    protected int capacity;
    /**
     * 对象数组
     */
    protected Object[] mQueue;
    /**
     * 队首元素的位置
     */
    protected int f = 0;
    /**
     * 队尾元素的位置
     */
    protected int r = 0;

    /**
     * 构造方法（空队列）
     */
    public QueueArray() {
        this(CAPACITY);
    }

    /**
     * 按指定容量创建对象
     *
     * @param cap
     */
    public QueueArray(int cap) {
        capacity = cap;
        mQueue = new Object[capacity];
    }

    @Override
    public int getSize() {
        return (capacity - f + r) % capacity;
    }


    @Override
    public boolean isEmpty() {
        return (f == r);
    }

    @Override
    public Object front() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("意外：队列空");
        }
        return mQueue[f];

    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {
        if (getSize() == capacity - 1) {
            throw new ExceptionQueueFull("Queue overflow.");
        }
        mQueue[r] = obj;
        r = (r + 1) % capacity;
    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        Object elem;
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("意外：队列空");
        }
        elem = mQueue[f];
        mQueue[f] = null;
        f = (f + 1) % capacity;
        return elem;
    }

    @Override
    public void Traversal() {
        for (int i = f; i < r; i++) {
            System.out.print(mQueue[i] + " ");
        }
        System.out.println();
    }
}

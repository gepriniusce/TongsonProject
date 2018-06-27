package pr.tongson.base.dsa.stack;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> <br>
 *
 * @author tongs
 */
public class StackArray implements Stack {

    /**
     * 数组的默认容量
     */
    public static final int CAPACITY = 1024;
    
    /**
     * 数组的实际容量
     */
    protected int capacity;
    
    /**
     * 对象数组
     */
    protected Object[] mStack;
    
    /**
     * 栈顶元素的位置
     */
    protected int top = -1;

    /**
     * 按默认容量创建栈对象
     */
    public StackArray() {
        this(CAPACITY);
    }


    /**
     * 按指定容量创建栈对象
     *
     * @param cap
     */
    public StackArray(int cap) {
        capacity = cap;
        mStack = new Object[capacity];
    }


    /**
     * 获取栈当前的规模
     *
     * @return
     */
    @Override
    public int getSize() {
        return (top + 1);
    }

    /**
     * 测试栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (top < 0);
    }


    /**
     * 入栈
     *
     * @param obj
     * @throws ExceptionStackFull
     */
    @Override
    public void push(Object obj) throws ExceptionStackFull {
        if (getSize() == capacity) {
            throw new ExceptionStackFull("意外：栈溢出");
        }
        mStack[++top] = obj;
    }


    /**
     * 取栈顶元素
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    @Override
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        return mStack[top];
    }


    /**
     * 出栈
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    @Override
    public Object pop() throws ExceptionStackEmpty {
        Object elem;
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        elem = mStack[top];
        mStack[top--] = null;
        return elem;
    }
}

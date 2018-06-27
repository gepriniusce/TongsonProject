package pr.tongson.base.dsa;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class Stack_Array implements Stack {
    //数组的默认容量
    public static final int CAPACITY = 1024;
    //数组的实际容量
    protected int capacity;
    //对象数组
    protected Object[] S;
    //栈顶元素的位置
    protected int top = -1;

    //按默认容量创建栈对象
    public Stack_Array() {
        this(CAPACITY);
    }

    //按指定容量创建栈对象
    public Stack_Array(int cap) {
        capacity = cap;
        S = new Object[capacity];
    }

    //获取栈当前的规模
    public int getSize() {
        return (top + 1);
    }

    //测试栈是否为空
    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    //入栈
    @Override
    public void push(Object obj) throws ExceptionStackFull {
        if (getSize() == capacity) {
            throw new ExceptionStackFull("意外：栈溢出");
        }
        S[++top] = obj;
    }

    //取栈顶元素
    @Override
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        return S[top];
    }

    //出栈
    @Override
    public Object pop() throws ExceptionStackEmpty {
        Object elem;
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        elem = S[top];
        S[top--] = null;
        return elem;
    }
}

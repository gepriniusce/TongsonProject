package pr.tongson.lib.dsa.stack;

import pr.tongson.lib.dsa.linkedlist.Node;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class StackList {
    /**
     * 指向栈顶元素
     */
    protected Node top;
    /**
     * 栈中元素的数目
     */
    protected int size;


    /**
     * 构造方法（空栈）
     */
    public StackList() {
        top = null;
        size = 0;
    }


    /**
     * 查询当前栈的规模
     *
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     * 判断是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == null) ? true : false;
    }

    /**
     * 压栈
     *
     * @param elem
     */
    public void push(Object elem) {
        //创建一个新节点，将其作为首节点插入
        Node v = new Node(elem, top);
        //更新首节点引用
        top = v;
        //更新规模记录
        size++;
    }


    /**
     * 读取（但不删除）栈顶
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    public Object top() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        return top.getElem();
    }


    /**
     * 弹出栈顶
     *
     * @return
     * @throws ExceptionStackEmpty
     */
    public Object pop() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("意外：栈空");
        }
        Object temp = top.getElem();
        //更新首节点引用
        top = top.getNext();
        //更新规模记录
        size--;
        return temp;
    }
}

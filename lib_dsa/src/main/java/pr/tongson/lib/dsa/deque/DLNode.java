package pr.tongson.lib.dsa.deque;

import pr.tongson.lib.dsa.linkedlist.Position;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class DLNode implements Position {
    /**
     * 数据对象
     */
    private Object element;
    /**
     * 指向前驱节点
     */
    private DLNode prev;
    /**
     * 指向后继节点
     */
    private DLNode next;

    /**************************** 构造函数 ****************************/
    public DLNode() {
        this(null, null, null);
    }

    /**
     * 注意三个参数的次序：数据对象、前驱节点、后继节点
     *
     * @param e 数据对象
     * @param p 前驱节点
     * @param n 后继节点
     */
    public DLNode(Object e, DLNode p, DLNode n) {
        element = e;
        prev = p;
        next = n;
    }


    /**************************** Position接口方法 ****************************/

    /**
     * 返回存放于该位置的元素
     *
     * @return
     */
    @Override
    public Object getElem() {
        return element;
    }

    /**
     * 将给定元素存放至该位置，返回此前存放的元素
     *
     * @param e
     * @return
     */
    @Override
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }

    /**************************** 双向链表节点方法 ****************************/

    /**
     * 找到后继位置
     *
     * @return
     */
    public DLNode getNext() {
        return next;
    }

    /**
     * 找到前驱位置
     *
     * @return
     */
    public DLNode getPrev() {
        return prev;
    }

    /**
     * 修改后继位置
     *
     * @param newNext
     */
    public void setNext(DLNode newNext) {
        next = newNext;
    }

    /**
     * 修改前驱位置
     *
     * @param newPrev
     */
    public void setPrev(DLNode newPrev) {
        prev = newPrev;
    }
}

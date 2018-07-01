package tongson.lib.dsa.linkedlist;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>
 * 每个节点的 next 引用都相当于一个链接或指针，指向另一节点。借助于这些 next 引用，我们
 * 可以从一个节点移动至其它节点。链表的第一个和最后一个节点，分别称作链表的首节点（Head）
 * 和末节点（Tail）。末节点的特征是，其 next 引用为空。如此定义的链表，称作单链表（Singly linkedlist）。
 * 与数组类似，单链表中的元素也具有一个线性次序⎯⎯若 P 的 next 引用指向 S，则 P 就是 S
 * 的直接前驱，而 S 是 P 的直接后继。与数组不同的是，单链表的长度不再固定，而是可以根据实际
 * 需要不断变化。如此一来，包含 n 个元素的单链表只需占用 O(n)空间⎯⎯这要比定长数组更为灵活。 <br>
 *
 * 单链表节点类
 * 
 * @author tongs
 */
public class Node implements Position {
    /**
     * 数据对象
     */
    private Object element;
    /**
     * 指向后继节点
     */
    private Node next;

    /**************************** 构造函数 ****************************/
    /**
     * 指向数据对象、后继节点的引用都置空
     */
    public Node() {
        this(null, null);
    }

    /**
     * 指定数据对象及后继节点
     *
     * @param e
     * @param n
     */
    public Node(Object e, Node n) {
        element = e;
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

    /**************************** 单链表节点方法 ****************************/

    /**
     * 取当前节点的后继节点
     *
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * 修改当前节点的后继节点
     *
     * @param newNext
     */
    public void setNext(Node newNext) {
        next = newNext;
    }
}

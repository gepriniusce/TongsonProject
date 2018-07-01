package pr.tongson.lib.dsa.queue;

import pr.tongson.lib.dsa.linkedlist.Node;

/**
 * <b>Create Date:</b> 2018/6/27<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class QueueList {
    /**
     * 指向表首元素
     */
    protected Node head;
    /**
     * 指向表末元素
     */
    protected Node tail;
    /**
     * 队列中元素的数目
     */
    protected int size;


    /**
     * 构造方法（空队列）
     */
    public QueueList() {
        head = tail = null;
        size = 0;
    }


    /**
     * 查询当前队列的规模
     *
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (0 == size) ? true : false;
    }


    /**
     * 入队
     *
     * @param obj
     */
    public void enqueue(Object obj) {
        Node node = new Node();
        node.setElem(obj);
        //新节点作为末节点插入
        node.setNext(null);
        if (0 == size) {
            //若此前队列为空，则直接插入
            head = node;
        } else {
            //否则，将新节点接至队列末端
            tail.setNext(node);
        }
        //更新指向末节点引用
        tail = node;
        //更新规模
        size++;
    }


    /**
     * 出队
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    public Object dequeue() throws ExceptionQueueEmpty {
        if (0 == size) {
            throw new ExceptionQueueEmpty("意外：队列空");
        }
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if (0 == size) {
            //若队列已空，须将末节点引用置空
            tail = null;
        }
        return obj;
    }

    /**
     * 取（并不删除）队首元素
     *
     * @return
     * @throws ExceptionQueueEmpty
     */
    public Object front() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("意外：队列空");
        }
        return head.getElem();
    }

    /**
     * 遍历（不属于ADT）
     */
    public void Traversal() {
        Node p = head;
        while (null != p) {
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
    }
}

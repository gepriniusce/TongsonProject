package pr.tongson.lib.dsa.iterator;

import pr.tongson.lib.dsa.linkedlist.Position;
import pr.tongson.lib.dsa.list.List;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class IteratorPosition implements Iterator {
    /**
     * 列表
     */
    private List list;
    /**
     * 当前（下一个）位置
     */
    private Position nextPosition;

    /**
     * 默认构造方法
     */
    public IteratorPosition() {
        list = null;
    }

    /**
     * 构造方法
     *
     * @param L
     */
    public IteratorPosition(List L) {
        list = L;
        if (list.isEmpty()) {
            //若列表为空，则//当前位置置空
            nextPosition = null;
        } else {
            //否则//从第一个位置开始
            nextPosition = list.first();
        }
    }

    /**
     * 检查迭代器中是否还有剩余的位置
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return (nextPosition != null);
    }

    /**
     * 返回迭代器中的下一位置
     *
     * @return
     * @throws ExceptionNoSuchElement
     */
    @Override
    public Object getNext() throws ExceptionNoSuchElement {
        if (!hasNext()) {
            throw new ExceptionNoSuchElement("意外：没有下一位置");
        }
        Position currentPosition = nextPosition;
        if (currentPosition == list.last()) {
            //若已到达尾位置，则
            //不再有下一个位置
            nextPosition = null;
        } else {
            //否则
            //转向下一位置
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition;
    }
}

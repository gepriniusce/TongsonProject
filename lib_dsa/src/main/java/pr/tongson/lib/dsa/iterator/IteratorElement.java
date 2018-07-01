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
public class IteratorElement implements Iterator {
    /**
     * 列表
     */
    private List list;
    /**
     * 当前（下一个）元素的位置
     */
    private Position nextPosition;

    /**
     * 默认构造方法
     */
    public IteratorElement() {
        list = null;
    }

    /**
     * 构造方法
     *
     * @param L
     */
    public IteratorElement(List L) {
        list = L;
        //若列表为空，则
        if (list.isEmpty()) {
            //当前元素置空
            nextPosition = null;
        } else {//否则
            //从第一个元素开始
            nextPosition = list.first();
        }
    }

    /**
     * 检查迭代器中是否还有剩余的元素
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return (null != nextPosition);
    }


    /**
     * 返回迭代器中的下一元素
     *
     * @return
     * @throws ExceptionNoSuchElement
     */
    @Override
    public Object getNext() throws ExceptionNoSuchElement {
        if (!hasNext()) {
            throw new ExceptionNoSuchElement("意外：没有下一元素");
        }
        Position currentPosition = nextPosition;
        //若已到达尾元素，则
        if (currentPosition == list.last()) {
            //不再有下一元素
            nextPosition = null;
        } else {//否则
            //转向下一元素
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElem();
    }
}

package pr.tongson.base.dsa.iterator;

import pr.tongson.base.dsa.linkedlist.Position;
import pr.tongson.base.dsa.list.List;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class IteratorElement implements Iterator {
    private List list;//列表
    private Position nextPosition;//当前（下一个）元素的位置

    //默认构造方法
    public IteratorElement() {
        list = null;
    }

    //构造方法
    public IteratorElement(List L) {
        list = L;
        if (list.isEmpty())//若列表为空，则
            nextPosition = null;//当前元素置空
        else//否则
            nextPosition = list.first();//从第一个元素开始
    }

    //检查迭代器中是否还有剩余的元素
    public boolean hasNext() {
        return (null != nextPosition);
    }

    //返回迭代器中的下一元素
    public Object getNext() throws ExceptionNoSuchElement {
        if (!hasNext())
            throw new ExceptionNoSuchElement("意外：没有下一元素");
        Position currentPosition = nextPosition;
        if (currentPosition == list.last())//若已到达尾元素，则
            nextPosition = null;//不再有下一元素
        else//否则
            nextPosition = list.getNext(currentPosition);//转向下一元素
        return currentPosition.getElem();
    }
}

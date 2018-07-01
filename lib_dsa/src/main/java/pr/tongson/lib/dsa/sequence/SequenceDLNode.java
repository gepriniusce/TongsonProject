package pr.tongson.lib.dsa.sequence;

import pr.tongson.lib.dsa.deque.DLNode;
import pr.tongson.lib.dsa.linkedlist.Position;
import pr.tongson.lib.dsa.list.ExceptionPositionInvalid;
import pr.tongson.lib.dsa.vector.ExceptionBoundaryViolation;
import pr.tongson.lib.dsa.list.ListDLNode;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class SequenceDLNode extends ListDLNode implements Sequence {

    /**
     * 检查秩r是否在[0, n)之间
     */
    protected void checkRank(int r, int n) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：非法的秩" + r + "，应该属于[0, " + n + ")");
        }
    }

    /**
     * 若0 <= r < getSize()，则返回秩为r的元素所在的位置；否则，报错--O(n)
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Position rank2Pos(int r) throws ExceptionBoundaryViolation {
        DLNode node;
        checkRank(r, getSize());
        if (r <= getSize() / 2) {
            //若秩较小，则
            //从前端开始
            node = header.getNext();

            for (int i = 0; i < r; i++) {
                //逐一扫描
                node = node.getNext();
            }
        } else {
            //若秩较大，则
            //从后端开始
            node = trailer.getPrev();
            for (int i = 1; i < getSize() - r; i++) {
                //逐一扫描
                node = node.getPrev();
            }
        }
        return node;
    }

    /**
     * 若p是序列中的合法位置，则返回存放于p处的元素的秩；否则，报错--O(n)
     *
     * @param p
     * @return
     * @throws ExceptionPositionInvalid
     */
    @Override
    public int pos2Rank(Position p) throws ExceptionPositionInvalid {
        DLNode node = header.getNext();
        int r = 0;
        while (node != trailer) {
            if (node == p) {
                return (r);
            }
            node = node.getNext();
            r++;
        }
        throw new ExceptionPositionInvalid("意外：作为参数的位置不属于序列");
    }

    /**
     * 取秩为r的元素--O(n)
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return rank2Pos(r).getElem();
    }

    /**
     * 将秩为r的元素替换为obj--O(n)
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return replace(rank2Pos(r), obj);
    }

    /**
     * 插入obj，作为秩为r的元素--O(n)；返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        checkRank(r, getSize() + 1);
        if (getSize() == r) {
            insertLast(obj);
        } else {
            insertBefore(rank2Pos(r), obj);
        }
        return obj;
    }

    /**
     * 删除秩为r的元素--O(n)
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        checkRank(r, getSize());
        return remove(rank2Pos(r));
    }

}
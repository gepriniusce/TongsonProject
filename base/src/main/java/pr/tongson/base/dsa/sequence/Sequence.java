package pr.tongson.base.dsa.sequence;

import pr.tongson.base.dsa.linkedlist.Position;
import pr.tongson.base.dsa.list.ExceptionPositionInvalid;
import pr.tongson.base.dsa.list.List;
import pr.tongson.base.dsa.vector.ExceptionBoundaryViolation;
import pr.tongson.base.dsa.vector.Vector;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface Sequence extends Vector, List {
    //若0 <= r < getSize()，则返回秩为r的元素所在的位置；否则，报错
    public Position rank2Pos(int r) throws ExceptionBoundaryViolation;

    //若p是序列中的合法位置，则返回存放于p处的元素的秩；否则，报错
    public int pos2Rank(Position p) throws ExceptionPositionInvalid;
} 

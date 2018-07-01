package pr.tongson.lib.dsa.list;

import pr.tongson.lib.dsa.iterator.Iterator;
import pr.tongson.lib.dsa.linkedlist.Position;
import pr.tongson.lib.dsa.vector.ExceptionBoundaryViolation;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface List {


    /**
     * 查询列表当前的规模
     *
     * @return
     */
    int getSize();


    /**
     * 判断列表是否为空
     *
     * @return
     */
    boolean isEmpty();


    /**
     * 返回第一个元素（的位置）
     *
     * @return
     */
    Position first();


    /**
     * 返回最后一个元素（的位置）
     *
     * @return
     */
    Position last();


    /**
     * 返回紧接给定位置之后的元素（的位置）
     *
     * @param p
     * @return
     * @throws ExceptionPositionInvalid
     * @throws ExceptionBoundaryViolation
     */
    Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;


    /**
     * 返回紧靠给定位置之前的元素（的位置）
     *
     * @param p
     * @return
     * @throws ExceptionPositionInvalid
     * @throws ExceptionBoundaryViolation
     */
    Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;


    /**
     * 将e作为第一个元素插入列表
     *
     * @param e
     * @return
     */
    Position insertFirst(Object e);


    /**
     * 将e作为最后一个元素插入列表
     *
     * @param e
     * @return
     */
    Position insertLast(Object e);


    /**
     * 将e插入至紧接给定位置之后的位置
     *
     * @param p
     * @param e
     * @return
     * @throws ExceptionPositionInvalid
     */
    Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid;


    /**
     * 将e插入至紧靠给定位置之前的位置
     *
     * @param p
     * @param e
     * @return
     * @throws ExceptionPositionInvalid
     */
    Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid;


    /**
     * 删除给定位置处的元素，并返回之
     *
     * @param p
     * @return
     * @throws ExceptionPositionInvalid
     */
    Object remove(Position p) throws ExceptionPositionInvalid;


    /**
     * 删除首元素，并返回之
     *
     * @return
     */
    Object removeFirst();


    /**
     * 删除末元素，并返回之
     *
     * @return
     */
    Object removeLast();


    /**
     * 将处于给定位置的元素替换为新元素，并返回被替换的元素
     *
     * @param p
     * @param e
     * @return
     * @throws ExceptionPositionInvalid
     */
    Object replace(Position p, Object e) throws ExceptionPositionInvalid;


    /**
     * 位置迭代器
     *
     * @return
     */
    Iterator positions();


    /**
     * 元素迭代器
     *
     * @return
     */
    Iterator elements();
}

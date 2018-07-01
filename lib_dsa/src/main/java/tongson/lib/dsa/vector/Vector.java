package tongson.lib.dsa.vector;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public interface Vector {

    /**
     * 返回向量中元素数目
     *
     * @return
     */
    int getSize();


    /**
     * 判断向量是否为空
     *
     * @return
     */
    boolean isEmpty();


    /**
     * 取秩为r的元素
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    Object getAtRank(int r) throws ExceptionBoundaryViolation;


    /**
     * 将秩为r的元素替换为obj
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation;


    /**
     * 插入obj，作为秩为r的元素；返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

    //

    /**
     * 删除秩为r的元素
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    Object removeAtRank(int r) throws ExceptionBoundaryViolation;


}

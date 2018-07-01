package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Description:</b> 抽象迭代子角色 <br>
 */
public interface Iterator {
    /**
     * 迭代方法：移动到第一个元素
     */
    void first();

    /**
     * 迭代方法：移动到下一个元素
     */
    void next();

    /**
     * 迭代方法：是否是最后一个元素
     */
    boolean isDone();

    /**
     * 迭代方法：返还当前元素
     */
    Object currentItem();
}

package pr.tongson.lib.dsa.vector;

/**
 * <b>Create Date:</b> 2018/6/28<br>
 * <b>Email:</b> tongsonloo@gmail.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class VectorExtArray implements Vector {

    /**
     * 数组的容量，可不断增加
     */
    private int N = 8;

    /**
     * 向量的实际规模
     */
    private int n;

    /**
     * 对象数组
     */
    private Object A[];

    /**
     * 构造函数
     */
    public VectorExtArray() {
        A = new Object[N];
        n = 0;
    }

    /**
     * 返回向量中元素数目
     *
     * @return
     */
    @Override
    public int getSize() {
        return n;
    }

    /**
     * 判断向量是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    /**
     * 取秩为r的元素
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        return A[r];
    }

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    /**
     * 插入obj，作为秩为r的元素；并返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (0 > r || r > n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        if (N <= n) {
            //空间溢出的处理
            N *= 2;
            //开辟一个容量加倍的数组
            Object B[] = new Object[N];
            for (int i = 0; i < n; i++) {
                //A[]中内容复制至B[]
                B[i] = A[i];
            }
            //用B替换A（原A[]将被自动回收）
            A = B;
        }
        for (int i = n; i > r; i--) {
            //后续元素顺次后移
            A[i] = A[i - 1];
        }
        //插入
        A[r] = obj;
        //更新当前规模
        n++;
        return obj;
    }

    /**
     * 删除秩为r的元素
     *
     * @param r
     * @return
     * @throws ExceptionBoundaryViolation
     */
    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        if (0 > r || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        Object bak = A[r];
        for (int i = r; i < n - 1; i++) {
            //后续元素顺次前移
            A[i] = A[i + 1];
        }
        //更新当前规模
        n--;
        return bak;
    }
}

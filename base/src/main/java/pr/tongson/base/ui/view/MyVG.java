package pr.tongson.base.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * <b>Create Date:</b> 2018/6/29<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
public class MyVG extends ViewGroup {
    private static final String TAG = "Tongson MyVG";

    private Activity mActivity;

    public MyVG(Context context) {
        super(context);
        init(context);
    }


    public MyVG(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mActivity = (Activity) context;
        setWillNotDraw(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        /**
//         * 获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
//         */
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
//        // 计算出所有的childView的宽和高
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//
//
//        /**
//         * 记录如果是wrap_content是设置的宽和高
//         */
//        int width = 0;
//        int height = 0;
//
//        int cCount = getChildCount();
//
//        int cWidth = 0;
//        int cHeight = 0;
//        MarginLayoutParams cParams = null;
//
//        // 用于计算左边两个childView的高度
//        int lHeight = 0;
//        // 用于计算右边两个childView的高度，最终高度取二者之间大值
//        int rHeight = 0;
//
//        // 用于计算上边两个childView的宽度
//        int tWidth = 0;
//        // 用于计算下面两个childiew的宽度，最终宽度取二者之间大值
//        int bWidth = 0;
//
//        /**
//         * 根据childView计算的出的宽和高，以及设置的margin计算容器的宽和高，主要用于容器是warp_content时
//         */
//        for (int i = 0; i < cCount; i++) {
//            View childView = getChildAt(i);
//            cWidth = childView.getMeasuredWidth();
//            cHeight = childView.getMeasuredHeight();
//            cParams = (MarginLayoutParams) childView.getLayoutParams();
//
//            // 上面两个childView
//            if (i == 0 || i == 1) {
//                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
//            }
//
//            if (i == 2 || i == 3) {
//                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
//            }
//
//            if (i == 0 || i == 2) {
//                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
//            }
//
//            if (i == 1 || i == 3) {
//                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
//            }
//
//        }
//
//        width = Math.max(tWidth, bWidth);
//        height = Math.max(lHeight, rHeight);
//
//        /**
//         * 如果是wrap_content设置为我们计算的值
//         * 否则：直接设置为父容器计算的值
//         */
//        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? sizeWidth : width, (heightMode == MeasureSpec.EXACTLY) ? sizeHeight : height);

        View view = getChildAt(0);
        if (view != null) {
            view.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.AT_MOST));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, "onLayout--changed:" + changed + ",l:" + l + ",t:" + t + ",r:" + r + ",b:" + b);
        calBarHeight();
        calParentHeight();
    }

    protected void calBarHeight() {
        int statusBarHeight;

        Rect frame = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        statusBarHeight = frame.top;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            statusBarHeight = 44;
        }
        Log.i(TAG, "calBarHeight--statusBarHeight:" + statusBarHeight);

    }

    /**
     * 计算父亲View在屏幕的坐标
     */
    protected void calParentHeight() {
        int[] parentLocation = new int[2];
        View view = (View) getParent();
        view.getLocationInWindow(parentLocation);

        Log.i(TAG, "calParentHeight--parentLocation:" + parentLocation.toString());

    }

    /**
     * 蒙板层透明度
     */
    private int maskAlpha = 0xcc;

    /**
     * 蒙板层颜色
     */
    private int maskColor = 0xcc000000;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        ViewGroup auchorView = (ViewGroup) mActivity.findViewById(android.R.id.content);


        Paint bg_paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        bg_paint.setColor(maskColor);
        bg_paint.setAlpha(maskAlpha);
        canvas.drawRect(0, 0, auchorView.getWidth(), auchorView.getHeight(), bg_paint);
        
        addView1();
    }

    private void addView1() {
        TextView textView=new TextView(mActivity);
        textView.setText("66666667");
        textView.setTextColor(Color.RED);
        addView(textView);
        
    }


    public MyVG show() {
        final ViewGroup root = (ViewGroup) mActivity.findViewById(android.R.id.content);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        root.addView(MyVG.this, lp);
        //        if (mListener != null) {
        //            mListener.onShow(this);
        //        }
        return this;
    }

    public MyVG dismiss() {
        ((ViewGroup) mActivity.findViewById(android.R.id.content)).removeView(MyVG.this);
        //        if (mListener != null) {
        //            mListener.onDismiss(this);
        //        }
        return this;
    }
}

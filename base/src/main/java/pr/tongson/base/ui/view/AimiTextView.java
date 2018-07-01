package pr.tongson.base.ui.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * <b>Create Date:</b> 2018/6/12<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongson
 */
public class AimiTextView extends android.support.v7.widget.AppCompatTextView{
    public AimiTextView(Context context) {
        super(context);
    }

    public AimiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

}

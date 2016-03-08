package xemenes.filletlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by xemenes on 08/03/16.
 */
public class FilletLinearLayout extends LinearLayout {
    private XeDelegate xeDelegate;
    public FilletLinearLayout(Context context) {
        super(context);
    }

    public FilletLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        xeDelegate = new XeDelegate(this,context,attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        xeDelegate.setSelector();
    }
}

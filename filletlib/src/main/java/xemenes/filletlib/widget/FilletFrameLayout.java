package xemenes.filletlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by xemenes on 08/03/16.
 */
public class FilletFrameLayout extends FrameLayout {
    private XeDelegate xeDelegate;
    public FilletFrameLayout(Context context) {
        super(context);
    }

    public FilletFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        xeDelegate = new XeDelegate(this,context,attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        xeDelegate.setSelector();
    }
}

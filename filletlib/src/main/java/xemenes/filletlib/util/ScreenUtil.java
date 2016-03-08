package xemenes.filletlib.util;

import android.content.Context;

/**
 * Created by xemenes on 05/03/16.
 */
public class ScreenUtil {

    public static  int dp2px(float dp,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static  int sp2px(float sp,Context context) {

        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scale + 0.5f);
    }

}

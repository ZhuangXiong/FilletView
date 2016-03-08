package xemenes.filletlib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;

import xemenes.filletlib.R;


/**
 * Created by xemenes on 03/03/16.
 */
public class XeDelegate {

    private int radius_TL;
    private int radius_TR;
    private int radius_BL;
    private int radius_BR;
    private int radius;

    private int backgroundColor;
    private int strokeColor;

    private int pressbgColor;
    private int pressstokeColor;

    private int storkeWith;

    private View mView;
    private Context mContext;

    private GradientDrawable backgound = new GradientDrawable();
    private GradientDrawable backgoundPress = new GradientDrawable();

    public XeDelegate(View view, Context context, AttributeSet attributeSet){
        mView = view;
        mContext = context;
        obtainAttributeSet(context,attributeSet);
    }

    private void obtainAttributeSet(Context context, AttributeSet attributeSet) {
        TypedArray ta = mContext.obtainStyledAttributes(attributeSet, R.styleable.SearchView);
        backgroundColor = ta.getColor(R.styleable.SearchView_xe_background, Color.TRANSPARENT);
        strokeColor = ta.getColor(R.styleable.SearchView_xe_strokeColor,Color.TRANSPARENT);
        storkeWith = ta.getDimensionPixelSize(R.styleable.SearchView_xe_strokeWith,Color.TRANSPARENT);

        pressbgColor = ta.getColor(R.styleable.SearchView_xe_pressbgColor,Integer.MAX_VALUE);
        pressstokeColor = ta.getColor(R.styleable.SearchView_xe_pressstokeColor,Integer.MAX_VALUE);

        radius = ta.getDimensionPixelSize(R.styleable.SearchView_xe_radius,0);
        radius_TL = ta.getDimensionPixelSize(R.styleable.SearchView_xe_radius_Tl,0);
        radius_TR = ta.getDimensionPixelSize(R.styleable.SearchView_xe_radius_TR,0);
        radius_BL = ta.getDimensionPixelSize(R.styleable.SearchView_xe_radius_BL,0);
        radius_BR = ta.getDimensionPixelSize(R.styleable.SearchView_xe_radius_BR,0);

        ta.recycle();

    }

    //设置背景
    private void setDrawable (GradientDrawable gradientDrawable,int backgroundColor,int strokeColor){
        gradientDrawable.setColor(backgroundColor);

        if(radius_TL !=0 || radius_BL !=0||radius_BR !=0||radius_TR != 0){
            gradientDrawable.setCornerRadii(new float[]{radius_TL,radius_TL,radius_TR,radius_TR,radius_BL,radius_BL,radius_BR,radius_BR});
        }else {
            gradientDrawable.setCornerRadius(radius);
        }
        gradientDrawable.setStroke(storkeWith,strokeColor);
    }

    //设置点击效果
    public  void setSelector(){
        StateListDrawable selectorDrawable = new StateListDrawable();
        setDrawable(backgound,backgroundColor,strokeColor);

        //别用
        selectorDrawable.addState(new int[]{-android.R.attr.state_pressed},backgound);

        if(pressbgColor !=Integer.MAX_VALUE || pressstokeColor != Integer.MAX_VALUE){

            setDrawable(backgoundPress,pressbgColor == Integer.MAX_VALUE?backgroundColor:pressbgColor,pressstokeColor == Integer.MAX_VALUE?strokeColor:pressstokeColor);
            selectorDrawable.addState(new int[]{android.R.attr.state_pressed},backgoundPress);
        }

        mView.setBackgroundDrawable(selectorDrawable);
    }


    public int getRadius_TL() {
        return radius_TL;
    }

    public void setRadius_TL(int radius_TL) {
        this.radius_TL = radius_TL;
        setSelector();
    }

    public int getRadius_TR() {
        return radius_TR;
    }

    public void setRadius_TR(int radius_TR) {
        this.radius_TR = radius_TR;
        setSelector();
    }

    public int getRadius_BL() {
        return radius_BL;
    }

    public void setRadius_BL(int radius_BL) {
        this.radius_BL = radius_BL;
        setSelector();
    }

    public int getRadius_BR() {
        return radius_BR;
    }

    public void setRadius_BR(int radius_BR) {
        this.radius_BR = radius_BR;
        setSelector();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        setSelector();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        setSelector();
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        setSelector();
    }

    public int getStorkeWith() {
        return storkeWith;
    }

    public void setStorkeWith(int storkeWith) {
        this.storkeWith = storkeWith;
        setSelector();
    }

    public GradientDrawable getBackgound() {
        return backgound;
    }

    public void setBackgound(GradientDrawable backgound) {
        this.backgound = backgound;
        setSelector();
    }

    public int getPressbgColor() {
        return pressbgColor;
    }

    public void setPressbgColor(int pressbgColor) {
        this.pressbgColor = pressbgColor;
        setSelector();
    }

    public int getPressstokeColor() {
        return pressstokeColor;
    }

    public void setPressstokeColor(int pressstokeColor) {
        this.pressstokeColor = pressstokeColor;
        setSelector();
    }
}

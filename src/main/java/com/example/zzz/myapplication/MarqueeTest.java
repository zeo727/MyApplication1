package com.example.zzz.myapplication;

import android.content.Context;
import android.util.AttributeSet;

public class MarqueeTest extends android.support.v7.widget.AppCompatTextView {
    public MarqueeTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MarqueeTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTest(Context context) {
        super(context);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
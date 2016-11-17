package com.tikerdev.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

import com.tikerdev.views.util.FontCache;

/**
 * Created by Error404 on 18/5/2559.
 */
public class TDevAutoComplete extends AppCompatAutoCompleteTextView {

    private Typeface mTypeface;

    public TDevAutoComplete(Context context) {
        super(context);
    }

    public TDevAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithAttrs(attrs, 0, 0);
    }

    public TDevAutoComplete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWithAttrs(attrs, defStyleAttr, 0);
    }


    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TDevTextView,
                defStyleAttr, defStyleRes);
        try {
            int fontName = a.getInt(R.styleable.TDevTextView_fontName, 1);
            mTypeface = FontCache.applyCustomFont(getContext(), attrs, fontName);
            updateFontName();
        } finally {
            a.recycle();
        }

    }

    public void setFontName(Typeface typeface) {
        this.mTypeface = typeface;
        updateFontName();
    }

    private void updateFontName() {
        if (mTypeface != null) {
            setTypeface(mTypeface);
        }
    }
}

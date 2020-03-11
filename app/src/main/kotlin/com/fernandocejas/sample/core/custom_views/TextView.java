package com.fernandocejas.sample.core.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.fernandocejas.sample.R;

public class TextView extends AppCompatTextView {

    public TextView(Context context) {
        this(context, null);
    }

    public TextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        if (ta != null) {
            int fontAsset = ta.getInt(R.styleable.TextView_tvfonts, 0);
            Typeface typeFace = FontManager.getInstance(context).getByType(fontAsset);
            super.setTypeface(typeFace);
        }
    }

}


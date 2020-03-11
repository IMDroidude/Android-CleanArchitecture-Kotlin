package com.fernandocejas.sample.core.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.fernandocejas.sample.R;


public class EditText extends AppCompatEditText {

    public EditText(Context context) {
        this(context, null);
    }

    public EditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
        init(context, attrs);
    }

    public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EditText);
        if (ta != null) {
            int fontAsset = ta.getInt(R.styleable.EditText_etfonts, 0);
            Typeface typeFace = FontManager.getInstance(context).getByType(fontAsset);
            super.setTypeface(typeFace);
        }
    }

}


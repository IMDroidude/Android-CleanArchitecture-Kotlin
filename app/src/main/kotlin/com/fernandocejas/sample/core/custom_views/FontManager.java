package com.fernandocejas.sample.core.custom_views;

import android.content.Context;
import android.graphics.Typeface;

class FontManager {

    private static FontManager Instance;
    private Context context;

    private Typeface fontNormal;
    private Typeface fontBold;
    private Typeface fontItalic;


    private FontManager(Context context) {
        this.context = context;
        this.fontNormal = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        this.fontBold = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_bold.ttf");
    }

    public synchronized static FontManager getInstance(Context context) {
        if (Instance == null)
            Instance = new FontManager(context);

        return Instance;
    }

    public Typeface getByType(int type) {
        switch (type) {
            case 2:
                return FontManager.getInstance(context).getFontItalic();
            case 1:
                return FontManager.getInstance(context).getFontBold();
            case 0:
            default:
                return FontManager.getInstance(context).getFontNormal();
        }
    }

    public Typeface getFontNormal() {
        return fontNormal;
    }


    public Typeface getFontBold() {
        return fontBold;
    }

    public Typeface getFontItalic() {
        return fontItalic;
    }
}

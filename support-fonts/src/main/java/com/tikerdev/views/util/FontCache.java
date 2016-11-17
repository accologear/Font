package com.tikerdev.views.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.util.HashMap;

import static com.tikerdev.views.util.Config.ANDROID_SCHEMA;
import static com.tikerdev.views.util.Config.FONT_CS_CHAT_THAI_UI;
import static com.tikerdev.views.util.Config.FONT_KANIT;
import static com.tikerdev.views.util.Config.ROOT_DIRECTORY;


/**
 * Created by Error404 on 8/11/2559.
 */

public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontName, Context context) {
        Typeface typeface = fontCache.get(fontName);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontName, typeface);
        }

        return typeface;
    }


    public static Typeface selectTypeface(Context context, String fontName, int textStyle) {
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface(fontName + "-Bold.ttf", context);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.getTypeface(fontName + "-BoldItalic.ttf", context);

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface(fontName + "-Italic.ttf", context);

            case Typeface.NORMAL: // regular
            default:
                return FontCache.getTypeface(fontName + "-Regular.ttf", context);
        }
    }

    public static Typeface applyCustomFont(Context context, AttributeSet attrs, int fontName) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);
        String font;
        switch (fontName) {
            case 1:
                font = ROOT_DIRECTORY + FONT_KANIT;
                return FontCache.selectTypeface(context, font, textStyle);
            case 2:
            default:
                font = ROOT_DIRECTORY + FONT_CS_CHAT_THAI_UI;
                return FontCache.selectTypeface(context, font, textStyle);
        }
    }
}

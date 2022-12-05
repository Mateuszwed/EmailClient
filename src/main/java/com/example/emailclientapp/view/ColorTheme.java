package com.example.emailclientapp.view;

public enum ColorTheme {
    LIGHT,
    DEFAULT,
    DARK;

    public static String getCssPath(ColorTheme colorTheme){
        switch(colorTheme){
            case LIGHT:
                return "themeLight.css";
            case DEFAULT:
                return "themeDefault.css";
            case DARK:
                return "themeDark.css";
            default:
                return null;
        }
    }
}

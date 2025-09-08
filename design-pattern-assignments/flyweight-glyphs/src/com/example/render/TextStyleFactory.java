package com.example.render;

public class TextStyleFactory {

    private static final java.util.Map<String,TextStyle> styles = new java.util.HashMap<>();
    public static TextStyle get(String font, int size, boolean bold) {
        String key = font + "-" + size + "-" + bold;
        if (!styles.containsKey(key)) {
            styles.put(key, new TextStyle(font, size, bold));
        }
        return styles.get(key);
    }

    // need to make it thread-safe for production code
}

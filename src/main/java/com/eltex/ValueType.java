package com.eltex;


import java.util.Map;

public class ValueType {
    private static final Map<Integer, String> map = Map.of(
            1, "\u20BD",
            2, "Br",
            3, "\u20B8"
    );

    public static String getSymbol(int currencyCode) {
        return map.getOrDefault(currencyCode, "");
    }
}
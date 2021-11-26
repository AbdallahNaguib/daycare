package com.example.daycare.moshiJsonapi.core;

import java.lang.reflect.Field;

public interface JsonNameMapping {
    String getJsonName(Field field);
}

package com.example.daycare.moshiJsonapi.core;

import static com.example.daycare.moshiJsonapi.core.MoshiHelper.nextNullableObject;

import androidx.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManyResourceAdapter<T extends Many<?>> extends JsonAdapter<T> {
    private final Constructor<T> constructor;

    private final Map<String, FieldAdapter> bindings = new LinkedHashMap<>();
    private final JsonNameMapping jsonNameMapping;
    private final Moshi moshi;
    private static final int TYPE_ATTRIBUTE = 0x01;
    private static final int TYPE_RELATIONSHIP = 0x03;

    ManyResourceAdapter(Class<T> type, JsonNameMapping jsonNameMapping, Moshi moshi) {
        try {
            constructor = type.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No default constructor on [" + type + "]", e);
        }

        this.jsonNameMapping = jsonNameMapping;
        this.moshi = moshi;
        ParameterizedType superClass = (ParameterizedType) type.getGenericSuperclass();
        Type actualType = superClass.getActualTypeArguments()[0];
        Class<?> actualClass = Types.getRawType(actualType);
        addFields(actualClass);
    }

    private void addFields(Class<?> type) {
        for (Field field : ResourceAdapter.listFields(type, Resource.class)) {
            int modifiers = field.getModifiers();
            if (Modifier.isTransient(modifiers) || Modifier.isStatic(modifiers)) {
                // skip transient fields and static fields
                continue;
            }
            if (!Modifier.isPublic(modifiers) || Modifier.isFinal(modifiers)) {
                // make private or final fields accessible
                field.setAccessible(true);
            }
            String name = jsonNameMapping.getJsonName(field);
            if (bindings.containsKey(name)) {
                throw new IllegalArgumentException("Duplicated field '" + name + "' in [" + type + "].");
            }
            bindings.put(name, new FieldAdapter<>(field,
                    Relationship.class.isAssignableFrom(Types.getRawType(field.getGenericType())) ? TYPE_RELATIONSHIP : TYPE_ATTRIBUTE,
                    moshi.adapter(field.getGenericType(), AnnotationUtils.jsonAnnotations(field.getAnnotations()))));
        }
    }

    @Nullable
    @Override
    public T fromJson(JsonReader reader) throws IOException {
        return null;
    }

    public void readObjects(JsonReader reader,T resource) throws IOException {
        reader.beginArray();
        while (reader.hasNext()){
            Object object = resource.create();
            readFields(reader,object);
        }
        reader.endArray();
    }
    @Override
    public void toJson(JsonWriter writer, @Nullable T value) throws IOException {

    }

    private void readFields(JsonReader reader, Object resource) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            FieldAdapter fieldAdapter = bindings.get(reader.nextName());
            if (fieldAdapter != null) {
                fieldAdapter.readFrom(reader, resource);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    private static class FieldAdapter<T> {

        final Field field;
        final JsonAdapter<T> adapter;
        final int fieldType;

        FieldAdapter(Field field, int fieldType, JsonAdapter<T> adapter) {
            this.field = field;
            this.fieldType = fieldType;
            this.adapter = adapter;
        }

        void set(Object target, T value) {
            try {
                field.set(target, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        void readFrom(JsonReader reader, Object object) throws IOException {
            set(object, nextNullableObject(reader, adapter));
        }

    }
}

package com.example.daycare.moshiJsonapi.core;

import static com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY;
import static com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT;
import static com.squareup.moshi.JsonReader.Token.END_ARRAY;

import androidx.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.HashMap;

public class HashMapResourceAdapter extends JsonAdapter<HashMap<String, String>> {
    @Nullable
    @Override
    public HashMap<String, String> fromJson(JsonReader reader) throws IOException {
        HashMap<String, String> result = new HashMap<>();
        if(reader.peek() == BEGIN_ARRAY){
            reader.beginArray();
        }else{
            reader.beginObject();
        }
        while (reader.hasNext()) {
            String key = reader.nextName();
            String value = "";
            switch (reader.peek()) {
                case BEGIN_ARRAY:
                    value = readArray(reader);
                    break;
                case BEGIN_OBJECT:
                    value = readObject(reader);
                    break;
                default:
                    if(!checkIfNextIsNull(reader))
                        value = reader.nextString();
                    break;
            }
            result.put(key, value);
        }
        if(reader.peek() == END_ARRAY){
            reader.endArray();
        }else{
            reader.endObject();
        }
        return result;
    }

    private String readArray(JsonReader reader) throws IOException {
        reader.beginArray();
        StringBuilder value = new StringBuilder();
        while (reader.peek() == BEGIN_OBJECT) {
            String cur = readObject(reader);
            if (value.length() > 0) {
                value.append(",");
            }
            value.append(cur);
        }
        reader.endArray();
        return value.toString();
    }

    private String readObject(JsonReader reader) throws IOException {
        String value = "";
        reader.beginObject();
        while (reader.hasNext()) {
            String next = reader.nextName();
            if (next.equals("value")) {
                if(!checkIfNextIsNull(reader))
                    value = reader.nextString();
            }else{
                reader.skipValue();
            }
        }
        reader.endObject();
        return value;
    }
    private boolean checkIfNextIsNull(JsonReader reader) throws IOException {
        if(reader.peek() == JsonReader.Token.NULL){
            reader.nextNull();
            return true;
        }
        return false;
    }
    @Override
    public void toJson(JsonWriter writer, @Nullable HashMap<String, String> value) throws IOException {

    }
}

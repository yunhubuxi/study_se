package json;

import com.google.gson.*;

import java.lang.reflect.Type;

public class BooleanJsonAdapter implements JsonDeserializer, JsonSerializer {
    public BooleanJsonAdapter() {
    }

    public JsonElement serialize(Object arg0, Type arg1, JsonSerializationContext arg2) {
        if (arg0 == null) {
            return null;
        } else {
            Boolean date = (Boolean)arg0;
            boolean b = false;
            if (date == Boolean.TRUE) {
                b = true;
            }

            return new JsonPrimitive(b);
        }
    }

    public Object deserialize(JsonElement jel, Type type, JsonDeserializationContext cont) throws JsonParseException {
        return jel != null && !jel.isJsonNull() && !jel.getAsString().isEmpty() ? new Boolean(jel.getAsString()) : null;
    }
}


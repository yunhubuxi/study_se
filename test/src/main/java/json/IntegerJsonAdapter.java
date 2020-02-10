package json;

import com.google.gson.*;

import java.lang.reflect.Type;

public class IntegerJsonAdapter implements JsonDeserializer, JsonSerializer {
    public IntegerJsonAdapter() {
    }

    public JsonElement serialize(Object obj, Type type, JsonSerializationContext cont) {
        if (obj == null) {
            return null;
        } else {
            int data = (Integer)obj;
            return new JsonPrimitive(data);
        }
    }

    public Object deserialize(JsonElement jel, Type type, JsonDeserializationContext cont) throws JsonParseException {
        return jel != null && !jel.isJsonNull() && !jel.getAsString().isEmpty() ? new Integer(jel.getAsInt()) : null;
    }
}
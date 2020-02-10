package json;

import com.google.gson.*;

import java.lang.reflect.Type;

public class LongJsonAdapter implements JsonDeserializer, JsonSerializer {
    public LongJsonAdapter() {
    }

    public JsonElement serialize(Object obj, Type type, JsonSerializationContext cont) {
        if (obj == null) {
            return null;
        } else {
            long data = (Long)obj;
            return new JsonPrimitive(data);
        }
    }

    public Object deserialize(JsonElement jel, Type type, JsonDeserializationContext cont) throws JsonParseException {
        return jel != null && !jel.isJsonNull() && !jel.getAsString().isEmpty() ? new Long((long)jel.getAsInt()) : null;
    }
}

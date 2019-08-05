package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GsonHelper {
    public GsonHelper() {
    }

    public static Gson GetJSonBuilder() {
        Map<Class, Object> adapters = new HashMap();
        buildDefaultAdapter(adapters);
        return GetJSonBuilder(adapters, (String)null);
    }

    public static Gson GetJSonBuilder(String dateFormate) {
        Map<Class, Object> adapters = new HashMap();
        buildDefaultAdapter(adapters);
        return GetJSonBuilder(adapters, dateFormate);
    }

    public static Gson GetJSonBuilder(Map<Class, Object> registerAdapters, String dateFormate) {
        GsonBuilder builder = new GsonBuilder();
        if (null == dateFormate) {
            dateFormate = "yyyy-MM-dd";
        }

        builder = builder.enableComplexMapKeySerialization().serializeNulls().setDateFormat(dateFormate).setPrettyPrinting().setVersion(1.0D).disableHtmlEscaping();
        if (registerAdapters != null && registerAdapters.size() > 0) {
            Iterator var3 = registerAdapters.keySet().iterator();

            while(var3.hasNext()) {
                Class clz = (Class)var3.next();
                builder.registerTypeAdapter(clz, registerAdapters.get(clz));
            }
        }

        Gson gson = builder.create();
        return gson;
    }

    public static String ToJSon(Object obj) {
        return GetJSonBuilder().toJson(obj);
    }

    public static String ToJSon(Object obj, String dateFormate) {
        return GetJSonBuilder(dateFormate).toJson(obj);
    }

    public static Object FromJSon(String jsonStr, Class clz) {
        return GetJSonBuilder().fromJson(jsonStr, clz);
    }

    public static Object FromJSon(String jsonStr, Type type) {
        return GetJSonBuilder().fromJson(jsonStr, type);
    }

    private static Map<Class, Object> buildDefaultAdapter(Map<Class, Object> registerAdapters) {
        if (registerAdapters == null) {
            registerAdapters = new HashMap();
        }

        ((Map)registerAdapters).put(Boolean.class, new BooleanJsonAdapter());
        ((Map)registerAdapters).put(Integer.class, new IntegerJsonAdapter());
        ((Map)registerAdapters).put(Long.class, new LongJsonAdapter());
        return (Map)registerAdapters;
    }

    public static boolean isGoodJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            try {
                (new JsonParser()).parse(json);
                return true;
            } catch (JsonParseException var2) {
                return false;
            }
        }
    }
}

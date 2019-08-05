package json;


import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import java.util.Map;

public class ResultMessage {
    private static final String DATEFORMATE = "yyyy-MM-dd HH:mm:ss";
    private static final String[] JSONIGNOREPROPERTIES = new String[]{"cPassword", "cSalt"};
    private int code;
    private String message;
    private Object data;

    private ResultMessage(int code, String message, Object data) {
        if (message != null) {
            message = message.replaceFirst("^.*Exception:\\s*", "");
        }

        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static String data(Object data, String[] keys) {
        return getJsonResult(200, "操作成功", data, keys);
    }

    public static String data(Object data, boolean isHoldNull) {
        return isHoldNull ? holdNulldata(data) : data(data, (String[])null);
    }

    public static String data(Object data) {
        return data(data, (String[])null);
    }

    private static String holdNulldata(Object data) {
        ResultMessage result = new ResultMessage(200, "操作成功", data);
        return GsonHelper.ToJSon(result, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toMap(String data) {
        return data((Map)GsonHelper.FromJSon(data, Map.class), (String[])null);
    }

    public static String toMap(String data, boolean isHoldNull) {
        return data((Map)GsonHelper.FromJSon(data, Map.class), isHoldNull);
    }

    public static String formatDate(Object data) {
        return formatDate(data, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Object data, String dateFormat) {
        return formatDate(data, dateFormat, (String[])null);
    }

    public static String formatDate(Object data, String[] keys) {
        return formatDate(data, "yyyy-MM-dd HH:mm:ss", keys);
    }

    public static String formatDate(Object data, String dateFormate, String[] keys) {
        return getJsonResult(200, "操作成功", data, keys);
    }

    public static String success() {
        return data((Object)null);
    }

    public static String success(String message) {
        return getJsonResult(200, message, (Object)null, (String[])null);
    }

    public static String error(String message) {
        return getJsonResult(999, message, (Object)null, (String[])null);
    }

    public static String NoAuth(String message) {
        return getJsonResult(901, message, (Object)null, (String[])null);
    }

    public static String NoBind(String message, Object data) {
        return getJsonResult(902, message, data, (String[])null);
    }

    public static String invalidparameters() {
        return getJsonResult(998, "无效的参数或非法的请求！", (Object)null, (String[])null);
    }

    public static String NoLogin() {
        return NoLogin("请登录后操作!");
    }

    public static String NoLogin(String message) {
        return getJsonResult(900, message, (Object)null, (String[])null);
    }

    private static String getJsonResult(int code, String message, Object data, String[] keys) {
        ResultMessage result = new ResultMessage(code, message, data);
        return getJsonResult(result, keys);
    }

    private static String getJsonResult(ResultMessage result, String[] keys) {
        if (keys != null && keys.length != 0) {
            int len = keys.length;
            keys = (String[])Arrays.copyOf(keys, len + 2);
            keys[len] = "cPassword";
            keys[len + 1] = "cSalt";
        } else {
            keys = JSONIGNOREPROPERTIES;
        }

        GsonBuilder builder = new GsonBuilder();
        if (keys != null && keys.length > 0) {
            builder = builder.setExclusionStrategies(new ExclusionStrategy[]{new JsonKit(keys)});
        }

        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson = builder.create();
        return gson.toJson(result);
    }
}

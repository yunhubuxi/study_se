package json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class JsonKit implements ExclusionStrategy {
    String[] keys;

    public JsonKit(String[] keys) {
        this.keys = keys;
    }

    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes arg0) {
        String[] var2 = this.keys;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            if (key.equals(arg0.getName())) {
                return true;
            }
        }

        return false;
    }
}


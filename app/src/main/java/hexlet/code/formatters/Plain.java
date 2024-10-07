package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;

public class Plain {
    public static String format(Map<String, Map<String, Object>> compareResult) {
        StringJoiner result = new StringJoiner("\n");

        for (String key : compareResult.keySet()) {
            Map<String, Object> map = compareResult.get(key);
            String oldValue = convertObjToStr(map.get("oldValue"));
            String newValue = convertObjToStr(map.get("newValue"));
            String status = map.get("status").toString();

            switch (status) {
                case "equal":
                    break;
                case "added":
                    result.add("+ " + key + ": " + newValue);
                    break;
                case "removed":
                    result.add("- " + key + ": " + oldValue);
                    break;
                case "changed":
                    result.add("- " + key + ": " + oldValue);
                    result.add("+ " + key + ": " + newValue);
                    break;
                default:
                    throw new RuntimeException("\nUnsupported key status: " + status);
            }
        }

        return result.toString();
    }

    public static String convertObjToStr(Object obj) {
        if (obj instanceof String) {
            return "'" + obj.toString() + "'";
        } else if (obj instanceof Collection<?> || obj instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return obj != null ? obj.toString() : "null";
        }
    }
}

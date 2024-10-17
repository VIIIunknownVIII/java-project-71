package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static String format(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> diff : differences) {
            String key = diff.get("key").toString();
            String status = diff.get("status").toString();

            switch (status) {
                case "added":
                    result.append("Property '").append(key).append("' was added with value: ")
                            .append(formatValue(diff.get("newValue"))).append("\n");
                    break;
                case "removed":
                    result.append("Property '").append(key).append("' was removed\n");
                    break;
                case "updated":
                    result.append("Property '").append(key)
                            .append("' was updated. From ").append(formatValue(diff.get("oldValue")))
                            .append(" to ").append(formatValue(diff.get("newValue"))).append("\n");
                    break;
            }
        }

        return result.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}


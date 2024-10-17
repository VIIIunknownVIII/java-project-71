package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    public static String format(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> diff : differences) {
            String key = diff.get("key").toString();
            String status = diff.get("status").toString();

            switch (status) {
                case "added":
                    result.append("  + ").append(key).append(": ").append(diff.get("newValue")).append("\n");
                    break;
                case "removed":
                    result.append("  - ").append(key).append(": ").append(diff.get("oldValue")).append("\n");
                    break;
                case "updated":
                    result.append("  - ").append(key).append(": ").append(diff.get("oldValue")).append("\n");
                    result.append("  + ").append(key).append(": ").append(diff.get("newValue")).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ").append(diff.get("oldValue")).append("\n");
                    break;
            }
        }

        result.append("}");
        return result.toString();
    }
}

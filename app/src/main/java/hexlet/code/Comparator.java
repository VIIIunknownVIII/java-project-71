package hexlet.code;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.TreeSet;

public class Comparator {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var keys = new TreeSet<>(file1.keySet());
        keys.addAll(file2.keySet());
        List<Map<String, Object>> result = new ArrayList<>();

        for (var key : keys) {
            Map<String, Object> line = new HashMap<>();
            line.put("FIELD", key);
            Object value1 = file1.get(key);
            Object value2 = file2.get(key);

            if (value1 != null && value2 == null) {
                line.put("STATUS", "REMOVED");
                line.put("OLD_VALUE", value1);
            } else if (value1 == null && value2 != null) {
                line.put("STATUS", "ADDED");
                line.put("NEW_VALUE", value2);
            } else if (Objects.equals(value1, value2)) {
                line.put("STATUS", "SAME");
                line.put("OLD_VALUE", value1);
            } else {
                line.put("STATUS", "CHANGED");
                line.put("OLD_VALUE", value1);
                line.put("NEW_VALUE", value2);
            }
            result.add(line);
        }
        return result;
    }
}

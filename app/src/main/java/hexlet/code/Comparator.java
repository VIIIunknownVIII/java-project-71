package hexlet.code;

import java.util.*;

public class Comparator {

    public static Map<String, Map<String, Object>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        Map<String, Map<String, Object>> compareResult = new LinkedHashMap<>();

        for (String key : allKeys) {
            Map<String, Object> resultData = new HashMap<>();
            if (!map1.containsKey(key)) {
                resultData.put("status", "added");
                resultData.put("oldValue", null);
                resultData.put("newValue", map2.get(key));
            } else if (!map2.containsKey(key)) {
                resultData.put("status", "removed");
                resultData.put("oldValue", map1.get(key));
                resultData.put("newValue", null);
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                resultData.put("status", "equal");
                resultData.put("oldValue", map1.get(key));
                resultData.put("newValue", map2.get(key));
            } else {
                resultData.put("status", "changed");
                resultData.put("oldValue", map1.get(key));
                resultData.put("newValue", map2.get(key));
            }

            compareResult.put(key, resultData);
        }

        return compareResult;
    }
}

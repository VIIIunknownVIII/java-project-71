package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws Exception {
        ObjectMapper objectMapper;

        if (format.equals("json")) {
            objectMapper = new ObjectMapper();
        } else if (format.equals("yaml") || format.equals("yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + format);
        }

        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}

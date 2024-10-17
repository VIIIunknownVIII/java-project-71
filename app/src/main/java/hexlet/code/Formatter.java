package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import hexlet.code.formatters.JSONFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStyle(
            List<Map<String, Object>> differences, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return StylishFormatter.formatStylish(differences);
            case "plain":
                return PlainFormatter.formatPlain(differences);
            case "json":
                return JSONFormatter.formatJson(differences);
            default:
                throw new IllegalArgumentException("Unsupported format: " + formatName);
        }
    }
}


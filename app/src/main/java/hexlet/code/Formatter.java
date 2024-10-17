package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import hexlet.code.formatters.JSONFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> differences, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return StylishFormatter.format(differences);
            case "plain":
                return PlainFormatter.format(differences);
            case "json":
                return JSONFormatter.format(differences);
            default:
                throw new IllegalArgumentException("Unsupported format: " + formatName);
        }
    }
}

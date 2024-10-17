package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private String readExpectedResult(String expectedFileName) throws Exception {
        Path path = getFixturePath(expectedFileName);
        return new String(Files.readAllBytes(path));
    }

    @Test
    public void testGenerateNestedJson() throws Exception {
        String filePath1 = getFixturePath("file3.json").toString();
        String filePath2 = getFixturePath("file4.json").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "stylish");

        String expected = readExpectedResult("expected/StylishResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateNestedYml() throws Exception {
        String filePath1 = getFixturePath("file3.yml").toString();
        String filePath2 = getFixturePath("file4.yml").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "stylish");

        String expected = readExpectedResult("expected/StylishResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateJsonPlain() throws Exception {
        String filePath1 = getFixturePath("file3.json").toString();
        String filePath2 = getFixturePath("file4.json").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "plain");

        String expected = readExpectedResult("expected/PlainResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateYmlPlain() throws Exception {
        String filePath1 = getFixturePath("file3.yml").toString();
        String filePath2 = getFixturePath("file4.yml").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "plain");

        String expected = readExpectedResult("expected/PlainResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateJson() throws Exception {
        String filePath1 = getFixturePath("file3.json").toString();
        String filePath2 = getFixturePath("file4.json").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "json");

        String expected = readExpectedResult("expected/JsonResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateYml() throws Exception {
        String filePath1 = getFixturePath("file3.yml").toString();
        String filePath2 = getFixturePath("file4.yml").toString();

        String formattedResult = Differ.generate(filePath1, filePath2, "json");

        String expected = readExpectedResult("expected/JsonResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateWithoutFormatterJson() throws Exception {
        String filePath1 = getFixturePath("file3.json").toString();
        String filePath2 = getFixturePath("file4.json").toString();

        String formattedResult = Differ.generate(filePath1, filePath2);

        String expected = readExpectedResult("expected/StylishResult.txt");

        assertEquals(expected, formattedResult);
    }

    @Test
    public void testGenerateWithoutFormatterYml() throws Exception {
        String filePath1 = getFixturePath("file3.yml").toString();
        String filePath2 = getFixturePath("file4.yml").toString();

        String formattedResult = Differ.generate(filePath1, filePath2);

        String expected = readExpectedResult("expected/StylishResult.txt");

        assertEquals(expected, formattedResult);
    }
}


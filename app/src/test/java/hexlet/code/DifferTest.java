package hexlet.code;

import java.io.File;
import static hexlet.code.Differ.generate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DifferTest {

    private final String expectedJsonFormat = """
                {
                  - age: 18
                  + age: 24
                  + children: false
                  - marriage: false
                  + marriage: true
                    name: Darya
                  - surname: Selezneva
                  + surname: Krylova
                  - www: null
                }""";

    private final String expectedPlainFormat = """
                Property 'age' was updated. From 18 to 24
                Property 'children' was added with value: false
                Property 'marriage' was updated. From false to true
                Property 'name' was added with value: 'Darya'
                Property 'surname' was updated. From 'Selezneva' to 'Krylova'
                Property 'www' was removed""";

    @Test
    public void generateTestJson() throws Exception {
        String filePath1 = pathToFullPath("file1.json");
        String filePath2 = pathToFullPath("file2.json");

        // Замените "plain" на "json" для получения формата, который вам нужен
        String actual = generate(filePath1, filePath2, "json");
        System.out.println("Actual result for generateTestJson: " + actual);

        Assertions.assertEquals(expectedJsonFormat, actual);
    }

    @Test
    public void generateTestJsonPlain() throws Exception {
        String filePath1 = pathToFullPath("file1.json");
        String filePath2 = pathToFullPath("file2.json");

        String actual = generate(filePath1, filePath2, "plain");
        System.out.println("Actual result for generateTestJsonPlain: " + actual);

        Assertions.assertEquals(expectedPlainFormat, actual);
    }

    @Test
    public void generateTestYaml() throws Exception {
        String filePath1 = pathToFullPath("file3Test.yml");
        String filePath2 = pathToFullPath("file4Test.yml");

        String actual = generate(filePath1, filePath2, "plain");
        System.out.println("Actual result for generateTestYaml: " + actual);

        Assertions.assertEquals("", actual); // Ожидаем пустую строку, так как файлы пустые
    }

    @Test
    public void generateTestYaml2() throws Exception {
        String filePath1 = pathToFullPath("file1.yml");
        String filePath2 = pathToFullPath("file2.yml");

        String actual = generate(filePath1, filePath2, "plain");
        String expected2 = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was updated. From [complex value] to [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        System.out.println("Actual result for generateTestYaml2: " + actual);
        Assertions.assertEquals(expected2, actual);
    }

    @Test
    public void generateTestJsonToJson() throws Exception {
        String filePath1 = pathToFullPath("file1.json");
        String filePath2 = pathToFullPath("file2.json");

        String actual = generate(filePath1, filePath2, "json");
        System.out.println("Actual result for generateTestJsonToJson: " + actual);

        Assertions.assertEquals(expectedJsonFormat, actual);
    }

    @Test
    public void generateTestJsonWithNullFile1() throws Exception {
        final String expectedRemovedFormat = """
            Property 'age' was removed
            Property 'marriage' was removed
            Property 'name' was removed
            Property 'surname' was removed
            Property 'www' was removed""";
        String filePath1 = pathToFullPath("file1.json");
        String filePath2 = pathToFullPath("emptyFile.yml");

        String actual = generate(filePath1, filePath2, "plain");
        System.out.println("Actual result for generateTestJsonWithNullFile1: " + actual);

        Assertions.assertEquals(expectedRemovedFormat, actual);
    }

    @Test
    public void generateTestJsonWithNullFile2() throws Exception {
        final String expected4 = """
                Property 'age' was added with value: 18
                Property 'marriage' was added with value: false
                Property 'name' was added with value: 'Darya'
                Property 'surname' was added with value: 'Selezneva'
                Property 'www' was added with value: null""";
        String filePath1 = pathToFullPath("emptyFile.yml");
        String filePath2 = pathToFullPath("file1.json");

        String actual = generate(filePath1, filePath2, "plain");
        System.out.println("Actual result for generateTestJsonWithNullFile2: " + actual);

        Assertions.assertEquals(expected4, actual);
    }

    public static String pathToFullPath(String path) throws IllegalAccessException {
        String path1 = "src/test/resources";
        File file = new File(path1);
        String absolutePath = file.getAbsolutePath();
        if (!path.startsWith("/home")) {
            return absolutePath + "/" + path;
        }
        throw new IllegalAccessException("Файл \"" + path + "\" не существует");
    }
}

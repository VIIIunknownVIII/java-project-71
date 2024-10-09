package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public final class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1",
            description = "Path to the first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2",
            description = "Path to the second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish",
            description = "Output format [default: stylish]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        try {
            String result = Differ.generate(filepath1, filepath2, format);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
        return 0;
    }
}

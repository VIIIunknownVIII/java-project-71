package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "app", mixinStandardHelpOptions = true, version = "app 1.0",
        description = "Example application with picocli")
public class App implements Callable<Integer> {

    @Option(names = {"-n", "--name"}, description = "Your name")
    private String name;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";
    @Option(names = {"-g", "--greeting"}, description = "Greeting message")
    private String greeting = "Hello";

    @Override
    public Integer call() {
        if (name == null || name.isEmpty()) {
            System.out.println("Name must be provided with -n or --name option.");
            return 1;
        }
        System.out.printf("%s, %s!%n", greeting, name);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

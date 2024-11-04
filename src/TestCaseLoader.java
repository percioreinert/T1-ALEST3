import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestCaseLoader {

    public static List<TestCase> loadTestCases(String filePath) {
        List<TestCase> testCases = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {

                String[] parts = line.split(";");
                int totalDistance = Integer.parseInt(parts[0].split("=")[1].trim());
                int dailyDistance = Integer.parseInt(parts[1].split("=")[1].trim());

                String[] stopPoints = parts[2].split("=")[1].trim().split(",");
                List<Integer> stops = new ArrayList<>();
                for (String stop : stopPoints) {
                    stops.add(Integer.parseInt(stop.trim()));
                }

                testCases.add(new TestCase(totalDistance, dailyDistance, stops));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return testCases;
    }
}

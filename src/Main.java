import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/testCases.txt";

        List<TestCase> testCases = TestCaseLoader.loadTestCases(filePath);

        for (int i = 0; i < testCases.size(); i++) {

            TestCase testCase = testCases.get(i);
            System.out.println("Caso " + (i + 1) + ":");
            System.out.println("Distância total: " + testCase.totalDistance + " km");
            System.out.println("Distância diária: " + testCase.dailyDistance + " km");
            System.out.println("Paradas: " + testCase.stops);

            // Tempo de início em nanosegundos
            long startTime = System.nanoTime();

            List<Integer> goodStops = OptimalStopsPoints.optimalStops(testCase.stops,
                    testCase.totalDistance,
                    testCase.dailyDistance);
            // Tempo de término em nanossegundos
            long endTime = System.nanoTime();

            // Tempo de execução em segundos
            double duration = (endTime - startTime) / 1000000000.0;

            System.out.println("Pontos de parada ótimos: " + goodStops);
            System.out.printf("Tempo de execução: %.6f segundos\n", duration);
            System.out.println("");
        }
    }
}

// for (TestCase testCase : testCases) {
// System.out.println("Distância total: " + testCase.totalDistance + " km");
// System.out.println("Distância diária: " + testCase.dailyDistance + " km");
// System.out.println("Paradas: " + testCase.stops);

// long startTime = System.nanoTime();

// List<Integer> goodStops = OptimalStopsPoints.optimalStops(
// testCase.stops, testCase.totalDistance, testCase.dailyDistance);

// long endTime = System.nanoTime();
// double duration = (endTime - startTime) / 1_000_000_000.0;

// System.out.println("Pontos de parada ótimos: " + goodStops);
// System.out.printf("Tempo de execução: %.6f segundos\n", duration);
// System.out.println("-----------");
// }
// }
// }

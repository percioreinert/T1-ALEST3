import java.util.List;

public class TestCase {
    int totalDistance;
    int dailyDistance;
    List<Integer> stops;

    public TestCase(int totalDistance, int dailyDistance, List<Integer> stops) {
        this.totalDistance = totalDistance;
        this.dailyDistance = dailyDistance;
        this.stops = stops;
    }
}

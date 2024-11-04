import java.util.ArrayList;
import java.util.List;

public class OptimalStopsPoints {

    public static List<Integer> optimalStops(List<Integer> stops, int totalDistance, int dailyDistance) {
        List<Integer> stopList = new ArrayList<>();
        int currentPos = 0;
        int i = 0;

        while (i < stops.size()) {
            int lastStop = currentPos;

            // Avança até o ponto mais distante possível dentro do limite diário
            while (i < stops.size() && stops.get(i) - currentPos <= dailyDistance) {
                lastStop = stops.get(i);
                i++;
            }

            // Adiciona o último ponto viável antes de ultrapassar o limite
            if (lastStop != currentPos) {
                if (stopList.isEmpty() || stopList.get(stopList.size() - 1) != lastStop) {
                    stopList.add(lastStop);
                }
                currentPos = lastStop;
            }

            if (currentPos >= totalDistance) {
                break;
            }
        }

        // Verifica se a última parada foi válida
        if (!stopList.isEmpty() && stopList.get(stopList.size() - 1) > totalDistance) {
            stopList.remove(stopList.size() - 1);
        }

        // Se o último ponto de parada não é a distância total e ainda está abaixo dele,
        // adicioná-lo
        if (currentPos < totalDistance) {
            for (int j = stops.size() - 1; j >= 0; j--) {
                if (stops.get(j) <= totalDistance) {
                    if (stopList.isEmpty() || stopList.get(stopList.size() - 1) != stops.get(j)) {
                        stopList.add(stops.get(j));
                    }
                    break;
                }
            }
        }

        return stopList;
    }
}

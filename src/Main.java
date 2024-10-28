import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int totalDistance = 20;
        int dailyDistance = 5;

        List<Integer> stops = List.of(5, -10, 12, 13, 18);

        List<Integer> goodStops = greedy(stops, totalDistance, dailyDistance);

        System.out.println("Pontos de parada: " + goodStops);
    }

    private static List<Integer> greedy(List<Integer> stops, Integer totalDistance, Integer dailyDistance) {
        List<Integer> stopList = new ArrayList<Integer>();
        int currentPos = 0;

        for (int i = 0; i < stops.size(); i++) {
            int nextStop = stops.get(i);

            // Se o próximo está fora de alcance diária, paramos no último ponto viável
            if (nextStop - currentPos > dailyDistance) {
                // se o ponto de parada é válido, adiciona e atualiza a posição atual
                if (i - 1 >= 0) {
                    stopList.add(stops.get(i - 1));
                    currentPos = stops.get(i - 1);
                }

                // verifica se atingiu o destino final
                if (currentPos + dailyDistance >= totalDistance) {
                    return stopList;
                }
            }
        }

        // adiciona a última parada, se necessário, para alcançar o destino
        if (currentPos + dailyDistance < totalDistance && !stops.isEmpty()) {
            stopList.add(stops.get(stops.size() - 1));
        }

        return stopList;
    }
}
/*
 * - Modelaremos a trilha do rally como um longo segmento de linha de
 * comprimento 𝐿.
 * - Vocês conseguem viajar no máximo 𝑑 quilômetros por dia antes de anoitecer.
 * - Assumiremos que os pontos de parada estão localizados a distâncias 𝑥1,
 * 𝑥2, … , 𝑥𝑛 do ponto de
 * partida.
 * - Assumiremos também que os seus amigos sempre estão corretos quando estimam
 * se conseguem
 * ou não chegar ao próximo ponto de parada antes do anoitecer.
 * - Vamos considerar um conjunto de pontos de parada como válidos se a
 * distância entre cada par
 * adjacente é no máximo 𝑑, e o primeiro ponto de parada está a no máximo uma
 * distância 𝑑 do início
 * e o último ponto de parada está a uma distância no máximo 𝑑 do final da
 * corrida. Portanto, um
 * conjunto de pontos de parada é valido se vocês conseguirem acampar nestes
 * pontos e ainda
 * completar toda a trilha.
 * - Assumimos que o conjunto 𝑛 com todos os pontos de parada é valido.
 */

// Distância L = quantos km? 100km por exemplo.
// Distância d = o máximo de km por dia. 10km por exemplo.
// Validar conjunto de entrada

// private static List<Integer> greedy(List<Integer> stops, Integer
// totalDistance, Integer dailyDistance) {
// // TODO: Comparar sempre dois pontos, vendo a distância entre eles, para
// // determinar se é possível ir ao próximo ponto naquele dia.
// var stopList = new ArrayList<Integer>();
// var reachedEnd = false;
// var daily = dailyDistance;
// var nextStop = 0;

// while (!reachedEnd) {
// var stop = stops.get(nextStop);
// if (stop <= daily) {
// stopList.add(stop);
// daily -= stop;
// totalDistance -= stop;
// } else {
// daily = dailyDistance;
// continue;
// }
// if (totalDistance <= 0) {
// reachedEnd = true;
// }
// }

// return stopList;
// TODO: Se for possível ir ao próximo ponto, diminuir a distância total do
// rally da distância percorrida, e diminuir a distância diária da distância
// percorrida.

// TODO: Salvar os pontos de parada por dia.

// TODO: O rally termina quando alcançar a distância total.

// TODO: Retornar os pontos selecionados.
// }
// }
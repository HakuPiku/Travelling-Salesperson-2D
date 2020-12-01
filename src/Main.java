import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int numCities = scanner.nextInt();
        Map map = new Map(numCities);
        for (int i = 0; i < numCities; i++){
            double x = scanner.nextFloat();
            double y = scanner.nextFloat();
            City city = new City(x, y);
            map.setCity(i, city);
        }
        map.setDistanceMatrix();
        List<Integer> tour = map.nearestNeighbor();
        List<Integer> optedTour = map.apply2Opt(tour);
        for (int i = 0; i < optedTour.size(); i++) {
            System.out.println(optedTour.get(i));
        }

        //System.out.println(tour);
        //System.out.println(map.getTourLength(tour));
        //System.out.println(map.getTourLength(map.apply2Opt(tour)));
    }

}

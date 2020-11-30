import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int numCities = scanner.nextInt();
        Map map = new Map(numCities);
        for (int i = 0; i < numCities; i++){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            City city = new City(x, y);
            map.setCity(i, city);
        }
    }
}

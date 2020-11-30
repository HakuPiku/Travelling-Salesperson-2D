import java.util.ArrayList;
import java.util.List;

public class Map {
    private City[] map;

    Map(int numCities){
        map = new City[numCities];
    }

    public void setCity(int index, City city){
        map[index] = city;
    }

    public City[] getMap() {
        return map;
    }

    public double getDistance(City a, City b){
        return Math.sqrt(Math.pow((a.getX() - b.getX()),2) + Math.pow((a.getY() - b.getY()),2));
    }

}

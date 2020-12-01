import java.util.ArrayList;
import java.util.List;

public class Map {
    public int numCities;
    private City[] map;
    public int[][] distanceMatrix;

    Map(int numCities){
        this.numCities = numCities;
        map = new City[numCities];
        distanceMatrix = new int[numCities][numCities];
    }

    public void setCity(int index, City city){
        map[index] = city;
    }

    public City[] getMap() {
        return map;
    }

    public int getDistance(City a, City b){
        return (int) Math.round(Math.sqrt(Math.pow((a.getX() - b.getX()),2) + Math.pow((a.getY() - b.getY()),2)));
    }
    //Make distance matrix instead;
    public void setDistanceMatrix(){
        for(int i = 0; i < this.numCities; i++){
            for(int j = 0; j < this.numCities; j++){
                distanceMatrix[i][j] = getDistance(this.map[i], this.map[j]);
            }
        }
    }

    public List<Integer> nearestNeighbor(){
        List<Integer> tour =  new ArrayList<>();
        tour.add(0);
        for(;;){
            int lastVisited = tour.get(tour.size() - 1 );
            int shortest = Integer.MAX_VALUE;
            int shortestIndex = Integer.MAX_VALUE;
            for(int i = 0; i < this.numCities; i++){
                if( !tour.contains(i) && this.distanceMatrix[lastVisited][i] < shortest ){
                    shortest = this.distanceMatrix[lastVisited][i];
                    shortestIndex = i;
                }
            }
            if(shortest == Integer.MAX_VALUE){
                return tour;
            }else{
                tour.add(shortestIndex);
            }
        }
    }

    public int getTourLength(List<Integer> tour){
        int sum = 0;
        for (int i = 0; i < tour.size()-1; i++) {
            sum += this.distanceMatrix[tour.get(i)][tour.get(i + 1)];
            //System.out.println(sum);
        }
        return sum;
    }

    public List<Integer> apply2Opt(List<Integer> tour){
        List<Integer> optedTour = tour;
        int bestLength = getTourLength(tour);
        for (int i = 1; i <= Math.round(this.numCities/3) - 1; i++){
            for (int j = i+1; j <= Math.round(this.numCities/3); j++) {
                List<Integer> newTour = OptSwap(tour, i,j);
                int newLength = getTourLength(newTour);
                if (newLength < bestLength){
                    optedTour = newTour;
                    bestLength = newLength;
                }
            }
        }
        return optedTour;
    }

    private List<Integer>  OptSwap(List<Integer> tour, int i, int j){
        List<Integer> optedTour = new ArrayList<Integer>();
        for (int k = 0; k < i; k++) {
            optedTour.add(tour.get(k));
        }
        for (int k = j; k >= i; k--) {
            optedTour.add(tour.get(k));
        }
        for (int k = j+1; k < tour.size(); k++) {
            optedTour.add(tour.get(k));
        }
        return optedTour;
    }

}

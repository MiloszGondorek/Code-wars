//task url: https://www.codewars.com/kata/5899a4b1a6648906fe000113
import java.util.ArrayList;
import java.util.List;

class Routes {

    public String findRoutes(String[][] routes) {
        List<String> places = new ArrayList<>();

        find:
        for(int i=0;i<routes.length;i++){
            for(int x=0;x<routes.length;x++) // Find first
                if(routes[i][0]==routes[x][1])
                    continue find;

            places.add(routes[i][0]); // Add first place
            places.add(routes[i][1]); // Add second place

            while (true){
                for(int x=0;x<routes.length;x++){
                    if(places.get(places.size()-1)==routes[x][0]){ // If last place is equals first from this route then add second from it;
                        places.add(routes[x][1]);
                        break;
                    }
                }
                if(places.size()>routes.length) // If number of places is bigger than routes break (1 route - 2 places, 2 routes - 3 places, 3 routes - 4 places, ...)
                    break;
            }
            break;
        }

        return String.join(", ",places);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Routes().findRoutes(new String[][]{{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}}));
    }
}

package square;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 * Created by Aleksandr on 19.03.2016.
 */
public class MyColors {

    private List<Color> listOfCOlor = new ArrayList<Color>();

    public MyColors() {
        listOfCOlor.add(Color.BLUE);
        listOfCOlor.add(Color.CYAN);
        listOfCOlor.add(Color.GREEN);
        listOfCOlor.add(Color.MAGENTA);
        listOfCOlor.add(Color.ORANGE);
        listOfCOlor.add(Color.BLUE);
    }

    public Color getRandomColor(){
        Random r = new Random();
        return listOfCOlor.get(r.nextInt(5));
    }
}

package program1;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends GraphicsProgram implements Constants {

    public Graph(ArrayList<Double> al) {
        // bitmap the arraylist

        GRect background = new GRect(0, 0, width, height);
        background.setFilled(true);
        background.setColor(Color.white);
        add(background);
        
        GRect border = background;
        border.setFilled(false);
        border.setColor(Color.black);
        add(border);
        
        
        
        
    }

}

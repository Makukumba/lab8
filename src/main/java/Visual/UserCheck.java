package Visual;

import Drago.Dragon;
import Drago.HeadComparatop;
import commands.Command;

import java.awt.*;
import java.util.*;

import static Managers.CommandManager.ts;

public class UserCheck {
    public HashMap<String, Color> colors;
    Random rand = new Random();

    Color c1;
    public UserCheck() {
        colors = new HashMap<>();

        for (Dragon dragon : ts ){
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            c1 = new Color(r,g,b);
       colors.put(dragon.getLogin(),c1);
        }

    }
    public Color CheckUser(Dragon dragon){
        Color c = null;
        for (Map.Entry<String, Color> color : colors.entrySet()){
            if (dragon.getLogin().equals(color.getKey())){
            c = color.getValue();
            }
        }
        return c;
    }
}


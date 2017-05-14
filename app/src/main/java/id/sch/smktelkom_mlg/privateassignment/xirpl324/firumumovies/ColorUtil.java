package id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Nadia Putri on 5/14/2017.
 */

public class ColorUtil {
    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.rgb(rnd.nextInt(192), rnd.nextInt(192), rnd.nextInt(192));
    }
}

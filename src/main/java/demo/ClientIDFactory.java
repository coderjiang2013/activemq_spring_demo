package demo;

import java.util.Random;

/**
 * Created by jiangjunguo on 3/30/16.
 */
public class ClientIDFactory {

    public static String getClientID(){
        Random ran = new Random();
        return String.valueOf(ran.nextInt(100));
    }

}

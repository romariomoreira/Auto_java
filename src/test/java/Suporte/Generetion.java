package Suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generetion {

    public static String datahoraarquivo (){
        Timestamp is = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyymmddhhmmss").format(is);

    }
}

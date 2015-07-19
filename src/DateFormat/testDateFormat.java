package DateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 优华 on 7/2/2015.
 */
public class testDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd-HH:mm");
//        转化出来的pattern
//        100000100|1000000010|1100000010|111100000010|11000000010|11100000010|
        try {
            Date d =   df.parse("20150619-240:60");
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

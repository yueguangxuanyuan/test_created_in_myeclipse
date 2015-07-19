package lambda;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 优华 on 2015/6/25.
 */
public class TestComparator {
    public static  void  main(String[] args){
        ArrayList<String> names = new ArrayList(5);
        names.add("aaaa");
        names.add("vbbb");
        names.add("baaa");
        names.add("ada");
        names.add("aaca");


        Collections.sort(names,(String s1,String s2)->{ return  s1.compareTo(s2);});

        for(String temp_s : names){
            System.out.println(temp_s);
        }
    }
}
